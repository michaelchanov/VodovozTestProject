package com.michaelchanov.vodovoztestproject.presentation.home.fragment

import android.os.Bundle
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

class HomeFragment : Fragment(R.layout.fragment_home) {

    companion object {
        private const val GOT_DATA_SUCCESSFULLY_STATUS_VALUE = "Success"
    }

    private val viewModel: HomeViewModel by viewModels(
        factoryProducer = { HomeViewModelFactory(GetGoodsUseCase(GoodsRepositoryImpl())) })
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val goodsAdapter = GoodsAdapter()
    private var listGoodsInfoVo: List<GoodInfoVo>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpTabLayoutCategories()
        subscribeOnViewModelData()
        viewModel.getGoods()
    }

    private fun subscribeOnViewModelData() {
        viewModel.goods.observe(viewLifecycleOwner) { goodsVo ->

            if (goodsVo.status == GOT_DATA_SUCCESSFULLY_STATUS_VALUE) {
                listGoodsInfoVo = goodsVo.goods
                goodsVo.goods.forEach { goodInfoVo ->
                    setGoodsAdapter(goods = listGoodsInfoVo?.get(0)?.goodsData)

                    binding.tlCategories.addTab(
                        binding.tlCategories.newTab().setText(goodInfoVo.name))
                }
            } else {
                with(binding) {
                    rvGoods.visibility = View.GONE
                    tlCategories.visibility = View.GONE
                }
            }
        }
    }

    private fun setUpTabLayoutCategories() {
        binding.tlCategories.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                setGoodsAdapter(goods = listGoodsInfoVo?.get(tab!!.position)?.goodsData)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    private fun setGoodsAdapter(goods: List<GoodVo>?) {
        with(binding.rvGoods) {
            goodsAdapter.submitList(goods)
            adapter = goodsAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
        }
    }
}