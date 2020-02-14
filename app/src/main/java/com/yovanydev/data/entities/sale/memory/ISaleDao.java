package com.yovanydev.data.entities.sale.memory;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.yovanydev.entities.sale.model.Sale;

import java.util.List;

@Dao
public interface ISaleDao {
    @Query("SELECT * FROM "+ Sale.TABLE_NAME + " WHERE invoice_id = :id")
    List<Sale> getSalesFromInvoice(int id);

    @Insert
    void addSale(Sale sale);

    @Update
    void updateSale(Sale sale);

    @Delete
    void deleteSale(Sale sale);
}
