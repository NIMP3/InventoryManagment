package com.yovanydev.data.entities.sale.memory;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

import com.yovanydev.entities.sale.model.Sale;

import java.util.List;

public class SaleRepository {
    @SuppressLint("StaticFieldLeak")
    private static SaleRepository repository;
    private ISaleDao saleDao;

    private SaleRepository(Context context) {
        Context appContext = context.getApplicationContext();
        SaleDataBase dataBase = Room
                .databaseBuilder(appContext, SaleDataBase.class, Sale.TABLE_NAME)
                .allowMainThreadQueries()
                .build();

        saleDao = dataBase.getSaleDao();
    }

    public static SaleRepository getRepository(Context context) {
        if (repository == null) repository = new SaleRepository(context);
        return repository;
    }

    public List<Sale> getSalesFromInvoice(int id) { return saleDao.getSalesFromInvoice(id);}
    public void addSale(Sale sale) {saleDao.addSale(sale);}
    public void updateSale(Sale sale) {saleDao.updateSale(sale);}
    public void deleteSale(Sale sale) {saleDao.deleteSale(sale);}
}
