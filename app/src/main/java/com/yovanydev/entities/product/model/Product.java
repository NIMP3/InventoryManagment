package com.yovanydev.entities.product.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.yovanydev.entities.general.model.Type;

@Entity(tableName = Product.TABLE_NAME)
public class Product {
    public static final String TABLE_NAME = "product";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") private int id = 0;

    @ColumnInfo(name = "name") @NonNull private String name;
    @ColumnInfo(name = "type") @NonNull private Type type;
    @ColumnInfo(name = "width") @NonNull private Float width;
    @ColumnInfo(name = "height") @NonNull private Float height;
    @ColumnInfo(name = "thickness") @NonNull private Float thickness;
    @ColumnInfo(name = "quantity") @NonNull private Integer quantity;
    @ColumnInfo(name = "gain_value") @NonNull private Float gain_value;
    @ColumnInfo(name = "purchase_value") @NonNull private Float purchase_value;
    @ColumnInfo(name = "total_value") @NonNull private Float total_value;

    public Product(@NonNull String name, @NonNull Type type, @NonNull Float width, @NonNull Float height, @NonNull Float thickness, @NonNull Integer quantity, @NonNull Float gain_value, @NonNull Float purchase_value) {
        this.name = name;
        this.type = type;
        this.width = width;
        this.height = height;
        this.thickness = thickness;
        this.quantity = quantity;
        this.gain_value = gain_value;
        this.purchase_value = purchase_value;
        this.total_value = width * height * quantity * purchase_value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public Type getType() {
        return type;
    }

    public void setType(@NonNull Type type) {
        this.type = type;
    }

    @NonNull
    public Float getWidth() {
        return width;
    }

    public void setWidth(@NonNull Float width) {
        this.width = width;
    }

    @NonNull
    public Float getHeight() {
        return height;
    }

    public void setHeight(@NonNull Float height) {
        this.height = height;
    }

    @NonNull
    public Float getThickness() {
        return thickness;
    }

    public void setThickness(@NonNull Float thickness) {
        this.thickness = thickness;
    }

    @NonNull
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(@NonNull Integer quantity) {
        this.quantity = quantity;
    }

    @NonNull
    public Float getGain_value() {
        return gain_value;
    }

    public void setGain_value(@NonNull Float gain_value) {
        this.gain_value = gain_value;
    }

    @NonNull
    public Float getPurchase_value() {
        return purchase_value;
    }

    public void setPurchase_value(@NonNull Float purchase_value) {
        this.purchase_value = purchase_value;
    }

    @NonNull
    public Float getTotal_value() {
        return total_value;
    }

    public void setTotal_value(@NonNull Float total_value) {
        this.total_value = total_value;
    }
}
