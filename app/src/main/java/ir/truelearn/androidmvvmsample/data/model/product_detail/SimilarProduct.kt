package ir.truelearn.androidmvvmsample.data.model.product_detail

data class SimilarProduct(
    val _id: String,
    val discountPercent: Int,
    val image: String,
    val name: String,
    val price: Int,
    val seller: String
)