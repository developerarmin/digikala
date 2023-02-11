package ir.truelearn.androidmvvmsample.data.model.product_detail

data class Comment(
    val _id: String,
    val description: String,
    val productId: String,
    val title: String,
    val userName: String
)