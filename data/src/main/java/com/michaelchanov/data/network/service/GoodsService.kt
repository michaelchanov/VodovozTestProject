package com.michaelchanov.data.network.service

import com.michaelchanov.data.network.models.GoodsDto
import retrofit2.http.GET

interface GoodsService {

    @GET("super_top.php?action=topglav")
    fun getGoods(): GoodsDto
}