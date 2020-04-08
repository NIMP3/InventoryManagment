package com.yovanydev.entities.sale.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.yovanydev.entities.invoice.model.Invoice;
import com.yovanydev.entities.product.model.Product;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
        foreignKeys = {
            @ForeignKey(
                    entity = Product.class,
                    parentColumns = "id",
                    childColumns = "product_id",
                    onDelete = CASCADE
            ),
            @ForeignKey(
                    entity = Invoice.class,
                    parentColumns = "id",
                    childColumns = "invoice_id",
                    onDelete = CASCADE
            )
        },
        indices = {
            @Index( value = {"product_id"}),
            @Index( value = {"invoice_id"})
        },
        tableName = Sale.TABLE_NAME)

public class Sale {
    public static final String TABLE_NAME = "sale";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") private int id = 0;

    @ColumnInfo(name = "width") @NonNull private Float width;
    @ColumnInfo(name = "height") @NonNull private Float height;
    @ColumnInfo(name = "quantity") @NonNull private Integer quantity;
    @ColumnInfo(name = "value") @NonNull private Float value;
    @ColumnInfo(name = "product_id") @NonNull private int product_id;
    @ColumnInfo(name = "invoice_id") @NonNull private int invoice_id;

    public Sale(@NonNull Float width, @NonNull Float height, @NonNull Integer quantity, @NonNull Float value, int product_id, int invoice_id) {
        this.width = width;
        this.height = height;
        this.quantity = quantity;
        this.value = value;
        this.product_id = product_id;
        this.invoice_id = invoice_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(@NonNull Integer quantity) {
        this.quantity = quantity;
    }

    @NonNull
    public Float getValue() {
        return value;
    }

    public void setValue(@NonNull Float value) {
        this.value = value;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }
}
