package com.michaelchanov.vodovoztestproject.presentation.home.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.michaelchanov.domain.use_cases.GetGoodsUseCase
import com.michaelchanov.vodovoztestproject.presentation.home.viewmodel.HomeViewModel

class HomeViewModelFactory(
    private val getGoodsUseCase: GetGoodsUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(getGoodsUseCase) as T
    }
}