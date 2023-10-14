package com.mcbedrock.app.apiservice

import com.mcbedrock.app.data.NewsItem
import retrofit2.http.GET

interface ApiService {
    @GET("news.json")
    suspend fun getItems(): List<NewsItem>
}