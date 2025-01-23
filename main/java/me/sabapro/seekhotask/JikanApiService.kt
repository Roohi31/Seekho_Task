package me.sabapro.seekhotask

import retrofit2.Call
import retrofit2.http.GET

interface JikanApiService {

    @GET("top/anime")
    fun getTopAnime(): Call<TopAnimeResponse>
}