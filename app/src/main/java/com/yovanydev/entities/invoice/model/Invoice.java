package com.yovanydev.entities.invoice.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = Invoice.TABLE_NAME)
public class Invoice {
    public static final String TABLE_NAME = "invoice";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") private int id = 0;

    @ColumnInfo(name = "date") @NonNull private Date date;
    @ColumnInfo(name = "customer") @NonNull private String customer;
    @ColumnInfo(name = "status") @NonNull private String status;
    @ColumnInfo(name = "address") @NonNull private String address;
    @ColumnInfo(name = "payment") @NonNull private Float payment;
    @ColumnInfo(name = "total_value") @NonNull private Float total_value;

    public Invoice(@NonNull Date date, @NonNull String customer, @NonNull String status, @NonNull String address, @NonNull Float payment, @NonNull Float total_value) {
        this.date = date;
        this.customer = customer;
        this.status = status;
        this.address = address;
        this.payment = payment;
        this.total_value = total_value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    @NonNull
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(@NonNull String customer) {
        this.customer = customer;
    }

    @NonNull
    public String getStatus() {
        return status;
    }

    public void setStatus(@NonNull String status) {
        this.status = status;
    }

    @NonNull
    public String getAddress() {
        return address;
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }

    @NonNull
    public Float getPayment() {
        return payment;
    }

    public void setPayment(@NonNull Float payment) {
        this.payment = payment;
    }

    @NonNull
    public Float getTotal_value() {
        return total_value;
    }

    public void setTotal_value(@NonNull Float total_value) {
        this.total_value = total_value;
    }
}
