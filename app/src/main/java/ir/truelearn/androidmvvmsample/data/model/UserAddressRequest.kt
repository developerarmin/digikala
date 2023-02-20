package ir.truelearn.androidmvvmsample.data.model

data class UserAddressRequest(
    val address: String,
    val name: String,
    val phone: String,
    val postalCode: String,
    val token: String
)