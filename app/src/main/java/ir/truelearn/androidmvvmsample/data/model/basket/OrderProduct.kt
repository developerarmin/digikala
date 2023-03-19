package ir.truelearn.androidmvvmsample.data.model.basket

data class OrderProduct(
    val count: Int,
    val discountPercent: Int,
    val image: String,
    val name: String,
    val price: Int,
    val productId: String,
    val seller: String
)