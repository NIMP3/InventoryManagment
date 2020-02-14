package com.yovanydev.data.entities.product.memory;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.yovanydev.entities.product.model.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductDataBase extends RoomDatabase {
    public abstract IProductDao getProductDao();
}
