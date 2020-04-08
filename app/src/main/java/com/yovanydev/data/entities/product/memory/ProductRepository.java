package com.yovanydev.data.entities.product.memory;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

import com.yovanydev.data.entities.company.memory.CompanyDataBase;
import com.yovanydev.entities.product.model.Product;

import java.util.List;

public class ProductRepository {
    @SuppressLint("StaticFieldLeak")
    private static ProductRepository repository;
    private IProductDao productDao;

    private ProductRepository(Context context) {
        Context appContext = context.getApplicationContext();
        CompanyDataBase dataBase = Room
                .databaseBuilder(appContext, CompanyDataBase.class, Product.TABLE_NAME)
                .allowMainThreadQueries()
                .build();
        productDao = dataBase.getProductDao();
    }

    public static ProductRepository getRepository(Context context) {
        if (repository == null) repository = new ProductRepository(context);
        return repository;
    }

    public List<Product> getProducts() {return productDao.getProducts();}
    public void addProduct(Product product) { productDao.addProduct(product);}
    public void updateProduct(Product product) { productDao.updateProduct(product);}
    public void deleteProduct(Product product) { productDao.deleteProduct(product);}
}
