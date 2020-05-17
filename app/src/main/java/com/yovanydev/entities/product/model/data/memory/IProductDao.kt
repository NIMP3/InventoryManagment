package com.yovanydev.entities.product.model.data.memory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.yovanydev.entities.product.model.Product

@Dao
abstract class IProductDao {
    @Insert
    abstract fun insertProduct(product: Product)

    @Insert
    abstract fun insertProducts(products: List<Product>)

    @Update
    abstract fun updateProduct(vararg product: Product)

    @Transaction
    open fun updateAllProducts(products: List<Product>) {
        deleteProducts()
        insertProducts(products)
    }

    @Delete
    abstract fun deleteProduct(vararg product: Product)

    @Query("DELETE FROM " + Product.TABLE_NAME)
    abstract fun deleteProducts()

    @Query("SELECT * FROM " + Product.TABLE_NAME)
    abstract fun getProducts() : LiveData<List<Product>>
}