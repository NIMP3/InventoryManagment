package com.yovanydev.entities.product.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

/**
 * Class Product : Manejar los datos de los diferentes productos del Inventario
 * @param name : Nombre del producto
 * @param type : Tipo del producto
 * @param width : Ancho del producto
 * @param height : Altura del producto
 * @param thickness : Grosor del producto
 * @param quantity : Cantidad del producto
 * @param gainValue : Valor de ganancia del producto
 * @param purchaseValue : Valor de compra del producto
 * @param totalValue : Valor total del producto
 */
@Entity(tableName = Product.TABLE_NAME)
class Product(
        @ColumnInfo(name = "name") @NotNull val name: String,
        @ColumnInfo(name = "type") @NotNull val type: Int,
        @ColumnInfo(name = "width") @NotNull val width: Float,
        @ColumnInfo(name = "height") @NotNull val height: Float,
        @ColumnInfo(name = "thickness") @NotNull val thickness: Float,
        @ColumnInfo(name = "quantity") @NotNull val quantity: Int,
        @ColumnInfo(name = "gain_value") @NotNull val gainValue: Float,
        @ColumnInfo(name = "purchase_value") @NotNull val purchaseValue: Float,
        @ColumnInfo(name = "total_value") @NotNull val totalValue: Float
) {
    companion object {
        const val TABLE_NAME : String = "product"
    }

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int = 0
}