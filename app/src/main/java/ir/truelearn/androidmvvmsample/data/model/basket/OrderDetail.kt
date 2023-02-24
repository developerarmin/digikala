package ir.truelearn.androidmvvmsample.data.model.basket


data class OrderDetail(
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