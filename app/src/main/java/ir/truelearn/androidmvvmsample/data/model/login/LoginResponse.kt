package ir.truelearn.androidmvvmsample.data.model.login

data class LoginResponse(
    val phone: String,
    val id: String,
    val role: String,
    val token: String,
)