package com.yovanydev.entities.product.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yovanydev.R
import com.yovanydev.entities.product.model.Product
import com.yovanydev.entities.product.model.ProductObservable
import com.yovanydev.entities.product.view.ProductRecyclerAdapter

class ProductViewModel(private val application: Application) : ViewModel() {

    private var productObservable: ProductObservable = ProductObservable(application)
    private var adapter: ProductRecyclerAdapter? = null

    fun getProducts() : LiveData<List<Product>>? {
        return productObservable.getProducts()
    }

    fun saveProduct(product: Product) {
        productObservable.saveProduct(product)
    }

    fun setProductsInRecyclerAdapter(products: List<Product>) {
        adapter?.setProductList(products)
        adapter?.notifyDataSetChanged()
    }

    fun getRecyclerProductAdapter() : ProductRecyclerAdapter? {
        adapter = ProductRecyclerAdapter(R.layout.cardview_product)
        return adapter
    }
}