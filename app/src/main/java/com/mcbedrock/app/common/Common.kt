package com.mcbedrock.app.common

import com.mcbedrock.app.network.APIService
import com.mcbedrock.app.network.Retrofit

object Common {
    private const val NEWS_URL = "https://launchercontent.mojang.com/"
    val getAPIService: APIService
        get() = Retrofit.getRetrofitClient(NEWS_URL).create(APIService::class.java)
}