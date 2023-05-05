package ir.truelearn.androidmvvmsample.data.model.comment

data class CommentRequest(
    val token: String,
    val title: String,
    val description: String,
    val productId: String,
    val userName: String,
)