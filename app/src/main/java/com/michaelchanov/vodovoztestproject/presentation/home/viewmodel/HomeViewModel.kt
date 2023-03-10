package com.michaelchanov.vodovoztestproject.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.michaelchanov.domain.use_cases.GetGoodsUseCase
import com.michaelchanov.vodovoztestproject.presentation.common.utils.extensions.toGoodsVo
import com.michaelchanov.vodovoztestproject.presentation.home.models.GoodsVo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val getGoodsUseCase: GetGoodsUseCase) : ViewModel() {

    private var _goods: MutableLiveData<GoodsVo> = MutableLiveData()
    val goods: LiveData<GoodsVo> = _goods

    fun getGoods() {
        CoroutineScope(Dispatchers.IO).launch {
            _goods.postValue(getGoodsUseCase.execute().toGoodsVo())
        }
    }
}