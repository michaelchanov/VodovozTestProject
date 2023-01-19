package com.michaelchanov.domain.use_cases

import com.michaelchanov.domain.models.Goods
import com.michaelchanov.domain.repository.GoodsRepository

class GetGoodsUseCase(private val repository: GoodsRepository) {

    suspend fun execute(): Goods {
        return repository.getGoods()
    }
}