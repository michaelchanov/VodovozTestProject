package com.michaelchanov.data.network.models

import com.google.gson.annotations.SerializedName
import com.michaelchanov.domain.models.Goods

data class GoodsDto(@SerializedName("status") val status: String,
                    @SerializedName("TOVARY") val goods: List<GoodInfoDto>)

fun GoodsDto.toGoods() = Goods(status, goods.map { goodInfoDto -> goodInfoDto.toGoodInfo() })