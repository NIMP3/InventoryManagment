package com.yovanydev.entities.product.model.data.memory

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yovanydev.data.entities.company.memory.CompanyDataBase
import com.yovanydev.entities.product.model.Product

class ProductMemoryRepository(application: Application) {
    private val dao: IProductDao? = CompanyDataBase.getInstance(application)?.getProductDao()

    fun insertProduct(product: Product) {
        dao?.insertProduct(product)
    }

    fun insertProducts(products: List<Product>) {
        dao?.insertProducts(products)
    }

    fun updateProduct(vararg product: Product) {
        dao?.updateProduct(*product)
    }

    fun updateAllProduct(products: List<Product>) {
        dao?.updateAllProducts(products)
    }

    fun deleteProduct(product: Product) {
        dao?.deleteProduct(product)
    }

    fun getProducts() : LiveData<List<Product>>? {
        return dao?.getProducts()
    }

}