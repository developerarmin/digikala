package ir.truelearn.androidmvvmsample.data.model.checkout

import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus
import ir.truelearn.androidmvvmsample.util.Constants


@Entity(tableName = Constants.ADDRESS_TABLE)
data class CartAddress(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val name: String,
    val phone: String,
    val province: String,
    val city: String,
    val postalAddress: String,
    val postalCode: String,
    val number: String,
    val unit: String,
    val recipientIsMeState:String,
    val nameRecipient: String,
    val phoneRecipient: String,
    val status: Boolean
)