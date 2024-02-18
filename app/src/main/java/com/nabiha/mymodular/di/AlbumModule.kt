package com.nabiha.mymodular.di

import com.nabiha.data.repoiml.AlbumRepoImpl
import com.nabiha.domain.repository.AlbumRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AlbumModule{

    @Binds
    fun bindAlbumRepository(albumRepoImpl: AlbumRepoImpl): AlbumRepository

}