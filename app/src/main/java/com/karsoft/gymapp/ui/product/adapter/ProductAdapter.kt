package com.karsoft.gymapp.ui.product.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.karsoft.gymapp.R
import com.karsoft.gymapp.databinding.ItemProductBinding
import com.karsoft.gymapp.data.product.ProductData
import com.karsoft.gymapp.databinding.ItemProductNameBinding

class ProductAdapter : ListAdapter<ProductData, ProductAdapter.Vh>(MyDiffUtil) {

    inner class Vh(private val binding: ItemProductNameBinding) : ViewHolder(binding.root) {

        fun bind() {
            val d = getItem(adapterPosition)
            binding.textName.text = d.name

            binding.btnDelete.setOnClickListener {
                onClick.invoke(d)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ItemProductNameBinding.bind(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_product_name,
                    parent,
                    false
                )
            )
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.bind()
    }

    private object MyDiffUtil : DiffUtil.ItemCallback<ProductData>() {
        override fun areItemsTheSame(oldItem: ProductData, newItem: ProductData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ProductData, newItem: ProductData): Boolean {
            return oldItem == newItem
        }
    }

    private var onClick: (productData: ProductData) -> Unit = {}
    fun setOnDeleteClickListener(a: (productData: ProductData) -> Unit) {
        this.onClick = a
    }
}