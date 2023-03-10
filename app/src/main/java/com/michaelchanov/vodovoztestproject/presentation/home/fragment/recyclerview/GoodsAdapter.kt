package com.michaelchanov.vodovoztestproject.presentation.home.fragment.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.michaelchanov.vodovoztestproject.R
import com.michaelchanov.vodovoztestproject.databinding.GoodsAdapterViewHolderBinding
import com.michaelchanov.vodovoztestproject.presentation.home.models.GoodVo

class GoodsAdapter : ListAdapter<GoodVo,
        GoodsAdapter.GoodsAdapterViewHolder>(GoodsDiffCallBack()) {

    companion object {
        private const val BASE_URL_FOR_GLIDE = "http://m.vodovoz.ru"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsAdapterViewHolder {

        return GoodsAdapterViewHolder(
            GoodsAdapterViewHolderBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: GoodsAdapterViewHolder, position: Int) {
        holder.bind(good = currentList[position])
    }

    class GoodsAdapterViewHolder(
        private val binding: GoodsAdapterViewHolderBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(good: GoodVo) {
            with(binding) {
                tvGoodsPrice.text = String.format(
                    binding.root.context.getString(
                        R.string.goods_adapter_view_holder_goods_price_text), good.goodsPrice)

                Glide.with(binding.root).load(
                    BASE_URL_FOR_GLIDE + good.goodsPicture).into(ivGoodsPicture)

                if (good.isLiked) {
                    ivLike.setImageResource(R.drawable.ic_like_active)
                } else {
                    ivLike.setImageResource(R.drawable.ic_like_inactive)
                }
            }
        }
    }

    class GoodsDiffCallBack() : DiffUtil.ItemCallback<GoodVo>() {

        override fun areItemsTheSame(oldItem: GoodVo, newItem: GoodVo): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: GoodVo, newItem: GoodVo): Boolean {
            return oldItem == newItem
        }
    }
}