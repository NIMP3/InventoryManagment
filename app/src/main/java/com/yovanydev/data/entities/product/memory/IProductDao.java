package com.yovanydev.data.entities.product.memory;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.yovanydev.entities.product.model.Product;

import java.util.List;

@Dao
interface IProductDao {
    @Query("SELECT * FROM " + Product.TABLE_NAME)
    List<Product> getProducts();

    @Insert
    void addProduct(Product product);

    @Update
    void updateProduct(Product product);

    @Delete
    void deleteProduct(Product product);
}
