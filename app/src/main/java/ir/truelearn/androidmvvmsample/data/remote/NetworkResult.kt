package ir.truelearn.androidmvvmsample.data.remote

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(message: String, data: T) : NetworkResult<T>(data, message)
    class Error<T>(message: String, data: T? = null) : NetworkResult<T>(data, message)
    class Loading<T> : NetworkResult<T>()
}