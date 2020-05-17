package com.yovanydev.entities.product.model

import android.app.Application
import android.content.Context
import androidx.databinding.BaseObservable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yovanydev.entities.product.model.data.memory.ProductMemoryRepository

class ProductObservable(application: Application) : BaseObservable() {

    private var memoryRepository : ProductMemoryRepository = ProductMemoryRepository(application)

    fun getProducts() : LiveData<List<Product>>? {
        return memoryRepository.getProducts()
    }

    fun saveProduct(product: Product) {
        memoryRepository.insertProduct(product)
    }
}