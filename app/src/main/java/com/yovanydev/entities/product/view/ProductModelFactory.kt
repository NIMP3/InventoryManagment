package com.yovanydev.entities.product.view

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yovanydev.entities.product.viewmodel.ProductViewModel

class ProductModelFactory (private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ProductViewModel::class.java)) {
            ProductViewModel(application) as T
        }
        else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}