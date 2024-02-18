package com.nabiha.data.repoiml

import com.nabiha.data.apiservice.ApiService
import com.nabiha.data.mapper.AlbumListMapper
import com.nabiha.data.utils.NetworkBoundResource
import com.nabiha.data.utils.mapFromApiResponse
import com.nabiha.domain.repository.AlbumRepository
import com.nabiha.domain.utils.Result
import com.nabiha.entity.AlbumEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AlbumRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val networkBoundResources: NetworkBoundResource,
    private val albumListMapper: AlbumListMapper
):AlbumRepository{

    override suspend fun fetchAlbumList(): Flow<Result<List<AlbumEntity>>> {
        return mapFromApiResponse(
            result = networkBoundResources.downloadData {
                apiService.fetchAlbumList()
            },albumListMapper
        )
    }

}