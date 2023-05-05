package ir.truelearn.androidmvvmsample.data.model.comment

data class CommentResponse(
    val _id: String,
    val title: String,
    val description: String,
    val productId: String,
    val userId: String,
    val userName: String,
    val updatedAt: String,
    val createdAt: String
)
