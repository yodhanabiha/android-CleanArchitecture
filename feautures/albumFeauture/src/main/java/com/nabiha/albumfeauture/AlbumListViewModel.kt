package com.nabiha.albumfeauture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nabiha.domain.usecase.AlbumListUseCase
import com.nabiha.domain.utils.Result
import com.nabiha.entity.AlbumEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumListViewModel @Inject constructor(
    private val albumListUseCase: AlbumListUseCase
): ViewModel(){
    private val _albumUiState = MutableStateFlow<AlbumUiState>(AlbumUiState.Loading)
    val albumUiState get() = _albumUiState.asStateFlow()

    init {
        fetchProfile()
    }

    private fun fetchProfile(){
        viewModelScope.launch {
            albumListUseCase.execute().collect{ response->
                when(response){
                    is Result.Error -> _albumUiState.value = AlbumUiState.Error(response.message)
                    is Result.Loading -> _albumUiState.value = AlbumUiState.Loading
                    is Result.Success -> _albumUiState.value = AlbumUiState.Success(response.data)
                }
            }
        }
    }

    fun handleAction(action: AlbumUiAction){
        when(action){
            AlbumUiAction.FetchAlbumList -> fetchProfile()
        }
    }
}

sealed interface AlbumUiState{
    object Loading : AlbumUiState
    data class Success(val data: List<AlbumEntity>): AlbumUiState
    data class Error(val message:String) : AlbumUiState
}

sealed interface AlbumUiAction{
    object FetchAlbumList:AlbumUiAction
}