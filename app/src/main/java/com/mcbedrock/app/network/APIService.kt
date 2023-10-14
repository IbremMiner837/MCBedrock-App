package com.mcbedrock.app.network

import com.mcbedrock.app.data.NewsEntry
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("news.json")
    fun getItems(): Call<MutableList<NewsEntry>>
}