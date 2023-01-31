package ir.truelearn.androidmvvmsample.data.model.basket

import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.truelearn.androidmvvmsample.util.Constants.SHOPPING_CART_TABLE

@Entity(tableName = SHOPPING_CART_TABLE)
data class CartItem(
    @PrimaryKey
    val itemID: String,
    val discountPercent: Int,
    val image: String,
    val name: String,
    val price: Int,
    val seller: String,
    val count: Int,
    val cartStatus: CartStatus
)