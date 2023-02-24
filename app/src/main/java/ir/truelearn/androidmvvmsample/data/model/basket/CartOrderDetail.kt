package ir.truelearn.androidmvvmsample.data.model.basket

import androidx.compose.runtime.MutableState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

data class CartOrderDetail(
    val orderAddress: String,
    val orderDate: String,
    val orderProducts: List<OrderProduct>,
//    val orderProducts: List<Unit>,
    val orderTotalDiscount: Int,
    val orderTotalPrice: Int,
    val orderUserName: String,
    val orderUserPhone: String,
    val token: String
)