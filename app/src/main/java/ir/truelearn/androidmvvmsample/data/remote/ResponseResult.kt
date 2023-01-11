package ir.truelearn.androidmvvmsample.data.remote

data class ResponseResult<T>(
    val message: String,
    val data: T,
    val success:Boolean
)