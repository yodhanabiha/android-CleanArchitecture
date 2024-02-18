package com.nabiha.apiresponse

import com.nabiha.entity.AlbumEntity

data class AlbumApiResponse(
    val success: Boolean,
    val dataalbum: List<AlbumEntity>
)
