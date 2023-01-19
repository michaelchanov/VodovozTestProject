package com.michaelchanov.domain.repository

import com.michaelchanov.domain.models.Goods

interface GoodsRepository {

    suspend fun getGoods(): Goods
}