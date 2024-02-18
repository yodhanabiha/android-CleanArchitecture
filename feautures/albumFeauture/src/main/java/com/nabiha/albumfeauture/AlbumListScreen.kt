package com.nabiha.albumfeauture

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.nabiha.albumfeauture.components.AlbumCard
import com.nabiha.designsystem.component.ScaffoldTopAppbar
import com.nabiha.designsystem.ui.NetworkErrorMessage
import com.nabiha.entity.AlbumEntity


@Composable
internal fun AlbumListScreenRoute(
    viewModel:AlbumListViewModel = hiltViewModel(),
    onBackBtnClick:()->Unit
){
    val albumUiState by viewModel.albumUiState.collectAsStateWithLifecycle()
    AlbumListScreen(
        albumUiState = albumUiState,
        onRefreshProfile = viewModel::handleAction,
        onBackBtnClick = onBackBtnClick
    )
}

@Composable
private fun AlbumListScreen(
    albumUiState: AlbumUiState,
    onRefreshProfile:(AlbumUiAction)->Unit,
    onBackBtnClick:()->Unit
){
    ScaffoldTopAppbar(
        title = "Album",
        onNavigationIconClick = onBackBtnClick
    ) {
        val modifier = Modifier.padding(it)
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            when(albumUiState){
                is AlbumUiState.Error -> NetworkErrorMessage(message = albumUiState.message){
                    onRefreshProfile(AlbumUiAction.FetchAlbumList)
                }
                AlbumUiState.Loading -> CircularProgressIndicator()
                is AlbumUiState.Success -> AlbumContentView(data = albumUiState.data)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun AlbumContentView(
    data: List<AlbumEntity>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalStaggeredGrid(
        modifier = modifier,
        columns = StaggeredGridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalItemSpacing = 10.dp
    ) {
        items(data){album->
            AlbumCard(album = album)
        }

    }

}