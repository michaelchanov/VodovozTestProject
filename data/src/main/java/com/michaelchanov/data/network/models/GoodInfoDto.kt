package com.michaelchanov.data.network.models

import com.google.gson.annotations.SerializedName
import com.michaelchanov.domain.models.GoodInfo

data class GoodInfoDto(@SerializedName("NAME") val name: String,
                       @SerializedName("data") val goodsData: List<GoodDto>)

fun GoodInfoDto.toGoodInfo() = GoodInfo(name, goodsData.map { goodDto -> goodDto.toGood() })