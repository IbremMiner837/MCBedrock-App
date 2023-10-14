package com.mcbedrock.app.repository

import com.mcbedrock.app.apiservice.ApiService
import com.mcbedrock.app.data.NewsItem

class NewsRepository(private val apiService: ApiService) {
    suspend fun getItems(): List<NewsItem> {
        return apiService.getItems()
    }
}