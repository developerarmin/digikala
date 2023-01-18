package ir.truelearn.androidmvvmsample.data.remote

import ir.truelearn.androidmvvmsample.data.model.AmazingItem
import ir.truelearn.androidmvvmsample.data.model.ResponseResult
import ir.truelearn.androidmvvmsample.data.model.Slider
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("getAmazingProducts")
    suspend fun getAmazingItems(): Response<ResponseResult<List<AmazingItem>>>

    @GET("getSlider")
    suspend fun getSlider(): Response<ResponseResult<List<Slider>>>
}