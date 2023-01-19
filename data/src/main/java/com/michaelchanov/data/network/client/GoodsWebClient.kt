package com.michaelchanov.data.network.client

import com.michaelchanov.data.network.service.GoodsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GoodsWebClient {

    val goodsService = Retrofit.Builder()
        .baseUrl("http://m.vodovoz.ru/newmobile/glavnaya/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GoodsService::class.java)
}