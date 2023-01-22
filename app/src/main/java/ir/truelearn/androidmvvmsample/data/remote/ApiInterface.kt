package ir.truelearn.androidmvvmsample.data.remote

import ir.truelearn.androidmvvmsample.data.model.*
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("getAmazingProducts")
    suspend fun getAmazingItems(): Response<ResponseResult<List<AmazingItem>>>
    @GET("getSuperMarketAmazingProducts")
    suspend fun getSuperMarketItems(): Response<ResponseResult<List<AmazingItem>>>

    @GET("getSlider")
    suspend fun getSlider(): Response<ResponseResult<List<Slider>>>

    @GET("get4Banners")
    suspend fun getProposalBanners(): Response<ResponseResult<List<Banners>>>
}