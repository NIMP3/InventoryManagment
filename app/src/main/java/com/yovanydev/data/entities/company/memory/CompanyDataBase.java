package com.yovanydev.data.entities.company.memory;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.yovanydev.data.entities.invoice.memory.IInvoiceDao;
import com.yovanydev.data.entities.product.memory.IProductDao;
import com.yovanydev.data.entities.sale.memory.ISaleDao;
import com.yovanydev.entities.company.model.Company;
import com.yovanydev.entities.invoice.model.Invoice;
import com.yovanydev.entities.product.model.Product;
import com.yovanydev.entities.sale.model.Sale;

@Database(entities = {
        Company.class,
        Invoice.class,
        Product.class,
        Sale.class
    }, version = 1)
public abstract class CompanyDataBase extends RoomDatabase {
    public abstract ICompanyDao getCompanyDao();
    public abstract IProductDao getProductDao();
    public abstract ISaleDao getSaleDao();
    public abstract IInvoiceDao getInvoiceDao();
}
