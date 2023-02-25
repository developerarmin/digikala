package ir.truelearn.androidmvvmsample.data.model.basket

data class ConfirmPurchase(
    val orderId: String,
    val token: String,
    val transactionId: String
)
