package ir.truelearn.androidmvvmsample.data.model

data class BestSellerItem(
    val _id: String,
    val discountPercent: Int,
    val image: String,
    val name: String,
    val price: Int,
    val seller: String
)