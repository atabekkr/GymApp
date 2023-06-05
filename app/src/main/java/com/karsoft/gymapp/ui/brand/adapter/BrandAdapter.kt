package com.karsoft.gymapp.ui.brand.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.karsoft.gymapp.R
import com.karsoft.gymapp.data.brand.BrandData
import com.karsoft.gymapp.databinding.ItemBrandBinding

class BrandAdapter : ListAdapter<BrandData, BrandAdapter.VH>(DiffUtilCallBack) {

    inner class VH(private val binding: ItemBrandBinding) : ViewHolder(binding.root) {
        fun bind() {}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            ItemBrandBinding.bind(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_brand,
                    parent,
                    false
                )
            )
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind()
    }

    private object DiffUtilCallBack : DiffUtil.ItemCallback<BrandData>() {
        override fun areItemsTheSame(oldItem: BrandData, newItem: BrandData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: BrandData, newItem: BrandData): Boolean {
            return oldItem == newItem
        }
    }
}