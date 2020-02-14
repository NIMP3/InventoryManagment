package com.yovanydev.data.entities.invoice.memory;

import androidx.room.Dao;
import androidx.room.Query;

import com.yovanydev.entities.invoice.model.Invoice;

import java.util.Date;
import java.util.List;

@Dao
public interface IInvoiceDao {
    @Query("SELECT * FROM " + Invoice.TABLE_NAME + " WHERE date >= :last_date")
    List<Invoice> getLastInvoices(Date last_date);
}
