package com.nabiha.albumfeauture

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val albumListScreenRoute = "albumListScreenRoute"

fun NavController.navigateToAlbumListScreen(){
    navigate(albumListScreenRoute)
}

fun NavGraphBuilder.albumListScreen(
    onBackBtnClick:()->Unit
){
    composable(route = albumListScreenRoute){
        AlbumListScreenRoute(
            onBackBtnClick = onBackBtnClick
        )
    }
}