package com.michaelchanov.vodovoztestproject.presentation.home.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayout
import com.michaelchanov.data.GoodsRepositoryImpl
import com.michaelchanov.domain.use_cases.GetGoodsUseCase
import com.michaelchanov.vodovoztestproject.R
import com.michaelchanov.vodovoztestproject.databinding.FragmentHomeBinding
import com.michaelchanov.vodovoztestproject.presentation.home.fragment.recyclerview.GoodsAdapter
import com.michaelchanov.vodovoztestproject.presentation.home.models.GoodInfoVo
import com.michaelchanov.vodovoztestproject.presentation.home.models.GoodVo
import com.michaelchanov.vodovoztestproject.presentation.home.viewmodel.HomeViewModel
import com.michaelchanov.vodovoztestproject.presentation.home.viewmodel.factory.HomeViewModelFactory

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels(
        factoryProducer = { HomeViewModelFactory(GetGoodsUseCase(GoodsRepositoryImpl())) })
    private val binding by viewBinding(FragmentHomeBinding::bind, R.id.fragmentContainer)
    private val goodsAdapter = GoodsAdapter()
    private var goodInfoVo: List<GoodInfoVo>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.e("TAG", "I'm here!")
        subscribeOnViewModelData()
        viewModel.getGoods()
    }

    private fun subscribeOnViewModelData() {
        viewModel.goods.observe(viewLifecycleOwner) { goodsVo ->
            goodInfoVo = goodsVo.goods
            goodsVo.goods.forEach { goodInfoVo ->
                binding.tlCategories.addTab(
                    binding.tlCategories.newTab().setText(goodInfoVo.name))
            }
        }
    }

    private fun setUpTabLayoutCategories() {
        binding.tlCategories.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                //setGoodsAdapter(goods = goodInfoVo[tab.position])
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun setGoodsAdapter(goods: List<GoodVo>) {
        with(binding.rvGoods) {
            goodsAdapter.submitList(goods)
            adapter = goodsAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}