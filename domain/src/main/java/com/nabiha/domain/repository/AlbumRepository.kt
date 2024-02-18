package com.nabiha.domain.repository

import com.nabiha.domain.utils.Result
import com.nabiha.entity.AlbumEntity
import kotlinx.coroutines.flow.Flow

interface AlbumRepository {
    suspend fun fetchAlbumList(): Flow<Result<List<AlbumEntity>>>
}