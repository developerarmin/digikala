package ir.truelearn.androidmvvmsample.data.model.basket

data class UserOrdersResponse(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val orderAddress: String,
    val orderDate: String,
    val orderProducts: List<OrderProduct>,
    val orderStatus: String,
    val orderTotalDiscount: Int,
    val orderTotalPrice: Int,
    val orderUserName: String,
    val orderUserPhone: String,
    val transactionId: String,
    val updatedAt: String,
    val userId: String
)