package com.michaelchanov.vodovoztestproject.presentation.common.utils.extensions

import com.michaelchanov.domain.models.GoodInfo
import com.michaelchanov.vodovoztestproject.presentation.home.models.GoodInfoVo

fun GoodInfo.toGoodInfoVo() = GoodInfoVo(name, goodsData.map { good -> good.toGoodVo() })