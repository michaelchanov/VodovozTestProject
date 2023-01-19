package com.michaelchanov.vodovoztestproject.presentation.common.utils.extensions

import com.michaelchanov.domain.models.Good
import com.michaelchanov.vodovoztestproject.presentation.home.models.GoodVo

fun Good.toGoodVo() = GoodVo(goodsPicture, goodsPrice, isLiked)