package com.mcbedrock.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mcbedrock.app.data.NewsEntry
import com.mcbedrock.app.repository.NewsRepository

class NewsViewModel: ViewModel() {
    private val newsRepository: NewsRepository
    val getNewsList: MutableLiveData<MutableList<NewsEntry>?>
        get() = newsRepository.getNewsEntryLiveData

    init {
        newsRepository = NewsRepository()
    }
}