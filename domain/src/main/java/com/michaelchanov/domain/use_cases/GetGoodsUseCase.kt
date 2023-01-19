package com.michaelchanov.domain.use_cases

import com.michaelchanov.domain.models.Goods
import com.michaelchanov.domain.repository.GoodsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class GetGoodsUseCase(private val repository: GoodsRepository) {

    fun execute(): Goods {
        var goods: Goods? = null

        CoroutineScope(Dispatchers.IO).launch {
            val goodsDeferred = CoroutineScope(Dispatchers.IO).async {
                repository.getGoods()
            }
            goods = goodsDeferred.await()
        }

        return goods!!
    }
}