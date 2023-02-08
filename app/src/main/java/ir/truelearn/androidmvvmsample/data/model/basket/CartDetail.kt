package ir.truelearn.androidmvvmsample.data.model.basket

data class CartDetail(
    val totalPrice: Int,
    val shippingCost: Int = 0,
    val discount: Int,
    val payablePrice: Int
)
