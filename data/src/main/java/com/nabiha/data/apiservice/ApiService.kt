package com.nabiha.data.apiservice

import com.nabiha.apiresponse.AlbumApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/album/view")
    suspend fun fetchAlbumList(): Response<AlbumApiResponse>

}