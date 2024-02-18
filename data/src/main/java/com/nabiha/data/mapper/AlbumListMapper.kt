package com.nabiha.data.mapper

import com.nabiha.apiresponse.AlbumApiResponse
import com.nabiha.data.utils.Mapper
import com.nabiha.entity.AlbumEntity
import javax.inject.Inject

class AlbumListMapper @Inject constructor() :
    Mapper<AlbumApiResponse, List<AlbumEntity>> {
    override fun mapFromApiResponse(type: AlbumApiResponse): List<AlbumEntity> {
        return if (type.success){
            type.dataalbum.map {
                AlbumEntity(
                    userId = it.userId,
                    AlbumID = it.AlbumID,
                    NamaAlbum = it.NamaAlbum,
                    Deskripsi = it.Deskripsi,
                    TanggalDibuat = it.TanggalDibuat
                )
            }
        }else{
            emptyList()
        }
    }
}