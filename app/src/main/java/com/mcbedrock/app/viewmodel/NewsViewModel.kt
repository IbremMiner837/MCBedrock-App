package com.mcbedrock.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcbedrock.app.data.NewsItem
import com.mcbedrock.app.repository.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {
    private val _items = MutableLiveData<List<NewsItem>>()
    val items: LiveData<List<NewsItem>> get() = _items

    fun fetchItems() {
        viewModelScope.launch {
            _items.value = repository.getItems()
        }
    }
}