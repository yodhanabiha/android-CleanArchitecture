package com.nabiha.domain.usecase

import com.nabiha.domain.repository.AlbumRepository
import com.nabiha.domain.utils.ApiUseCaseNonParams
import com.nabiha.entity.AlbumEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.nabiha.domain.utils.Result

class AlbumListUseCase @Inject constructor(
    private val repository: AlbumRepository
):ApiUseCaseNonParams<List<AlbumEntity>> {
    override suspend fun execute(): Flow<Result<List<AlbumEntity>>> {
        return repository.fetchAlbumList()
    }
}