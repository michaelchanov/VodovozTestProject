package com.michaelchanov.data

import com.michaelchanov.data.network.client.GoodsWebClient.goodsService
import com.michaelchanov.data.network.models.toGoods
import com.michaelchanov.domain.models.Goods
import com.michaelchanov.domain.repository.GoodsRepository

class GoodsRepositoryImpl : GoodsRepository {

    override suspend fun getGoods(): Goods {
        return goodsService.getGoods().toGoods()
    }
}