package com.michaelchanov.vodovoztestproject.presentation.common.utils.extensions

import com.michaelchanov.domain.models.Goods
import com.michaelchanov.vodovoztestproject.presentation.home.models.GoodsVo

fun Goods.toGoodsVo() = GoodsVo(status, goods.map { goodInfo -> goodInfo.toGoodInfoVo() })