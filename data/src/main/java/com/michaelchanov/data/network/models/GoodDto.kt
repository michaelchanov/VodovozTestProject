package com.michaelchanov.data.network.models

import com.google.gson.annotations.SerializedName
import com.michaelchanov.domain.models.Good

data class GoodDto(@SerializedName("DETAIL_PICTURE") val goodsPicture: String,
                   @SerializedName("PROPERTY_TSENA_ZA_EDINITSU_TOVARA_VALUE") val goodsPrice: Int,
                   @SerializedName("FAVORITE") val isLiked: Boolean)

fun GoodDto.toGood() = Good(goodsPicture, goodsPrice, isLiked)