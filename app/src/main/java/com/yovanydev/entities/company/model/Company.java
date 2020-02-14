package com.yovanydev.entities.company.model;

import android.content.ContentValues;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Company.TABLE_NAME)
public class Company {

    public static final String TABLE_NAME = "company";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") private int id = 0;

    @ColumnInfo(name = "name") @NonNull private String name;
    @ColumnInfo(name = "address") @NonNull private String address;
    @ColumnInfo(name = "phone") @NonNull private String phone;
    @ColumnInfo(name = "owner") @NonNull private String owner;
    @ColumnInfo(name = "email") @NonNull private String email;

    public Company(@NonNull String name, @NonNull String address, @NonNull String phone, @NonNull String owner, @NonNull String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.owner = owner;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
