package ir.truelearn.androidmvvmsample.data.model.profile

import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus
import ir.truelearn.androidmvvmsample.util.Constants.FAVORITELIST_TABLE

@Entity(tableName = FAVORITELIST_TABLE)
data class FavItem(
    @PrimaryKey
    val id: String,
    val discountPercent: Int,
    val image: String,
    val name: String,
    val price: Int,
    val seller: String,
    val star: Double
)
