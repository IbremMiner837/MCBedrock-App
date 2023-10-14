package com.mcbedrock.app.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.mcbedrock.app.common.Common
import com.mcbedrock.app.data.NewsEntry
import com.mcbedrock.app.network.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {
    private val apiService: APIService

    companion object {
        private const val TAG = "NewsRepository"
    }

    init {
        apiService = Common.getAPIService
    }

    val getNewsEntryLiveData: MutableLiveData<MutableList<NewsEntry>?>
        get() {
            val data: MutableLiveData<MutableList<NewsEntry>?> =
                MutableLiveData<MutableList<NewsEntry>?>()
            apiService.getItems().enqueue(object : Callback<MutableList<NewsEntry>>{
                override fun onResponse(
                    call: Call<MutableList<NewsEntry>>,
                    response: Response<MutableList<NewsEntry>>
                ) {
                    Log.e(TAG, "onResponse: " + response.code())
                    if (response.isSuccessful)
                        data.value = response.body()
                    else
                        data.value = null
                }

                override fun onFailure(call: Call<MutableList<NewsEntry>>, t: Throwable) {
                    Log.e(TAG, "onResponse: " + t.message)
                    data.value = null
                }
            })
            return data
        }
}