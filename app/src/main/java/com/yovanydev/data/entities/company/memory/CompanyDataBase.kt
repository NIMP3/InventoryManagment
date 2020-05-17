package com.yovanydev.data.entities.company.memory

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yovanydev.data.entities.invoice.memory.IInvoiceDao
import com.yovanydev.data.entities.sale.memory.ISaleDao
import com.yovanydev.entities.company.model.Company
import com.yovanydev.entities.invoice.model.Invoice
import com.yovanydev.entities.product.model.Product
import com.yovanydev.entities.product.model.data.memory.IProductDao
import com.yovanydev.entities.sale.model.Sale

@Database(entities = [Company::class, Invoice::class, Product::class, Sale::class], version = 1)
abstract class CompanyDataBase : RoomDatabase() {

    abstract fun getCompanyDao(): ICompanyDao
    abstract fun getInvoiceDao(): IInvoiceDao
    abstract fun getProductDao(): IProductDao
    abstract fun getSaleDao(): ISaleDao

    companion object {
        private const val DATABASE_NAME = "inventory_database"
        @Volatile
        private var INSTANCE: CompanyDataBase? = null

        fun getInstance(context: Context): CompanyDataBase? {
            INSTANCE
                    ?: synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CompanyDataBase::class.java,
                        DATABASE_NAME
                )
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE
        }
    }

}