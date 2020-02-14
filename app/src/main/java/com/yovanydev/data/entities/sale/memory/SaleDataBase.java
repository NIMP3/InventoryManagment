package com.yovanydev.data.entities.sale.memory;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.yovanydev.entities.sale.model.Sale;

@Database(entities = {Sale.class}, version = 1)
public abstract class SaleDataBase extends RoomDatabase {
    public abstract ISaleDao getSaleDao();
}
