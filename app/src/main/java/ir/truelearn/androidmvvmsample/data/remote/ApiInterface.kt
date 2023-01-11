package ir.truelearn.androidmvvmsample.data.remote

import ir.truelearn.androidmvvmsample.data.model.AmazingItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("getAmazingProducts")
    suspend fun getAmazingItems(): Response<ResponseResult<List<AmazingItem>>>
}