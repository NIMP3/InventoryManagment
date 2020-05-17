package com.yovanydev.entities.product.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.yovanydev.BR
import com.yovanydev.entities.product.model.Product
import com.yovanydev.entities.product.viewmodel.ProductViewModel

class ProductRecyclerAdapter(var resouce: Int) : RecyclerView.Adapter<ProductRecyclerAdapter.ProductViewHolder>() {

    private var products: List<Product>? = null

    fun setProductList(products: List<Product>) {
        this.products = products
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return products?.size ?: 0
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        products?.get(position)?.let { holder.setDataCard(it) }
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    private fun getLayoutIdForPosition(position: Int): Int {
        return resouce
    }

    class ProductViewHolder(var binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setDataCard(product: Product) {
            binding.setVariable(BR.product, product)
            binding.executePendingBindings()
        }

    }
}