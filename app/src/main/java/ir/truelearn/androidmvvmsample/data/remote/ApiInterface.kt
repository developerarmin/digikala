package ir.truelearn.androidmvvmsample.data.remote

import ir.truelearn.androidmvvmsample.data.model.*
import ir.truelearn.androidmvvmsample.data.model.category.SubCategory
import ir.truelearn.androidmvvmsample.data.model.home.AmazingItem
import ir.truelearn.androidmvvmsample.data.model.home.BestSellerItem
import ir.truelearn.androidmvvmsample.data.model.home.MostVisitedItem
import ir.truelearn.androidmvvmsample.data.model.home.Slider
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("getAmazingProducts")
    suspend fun getAmazingItems(): Response<ResponseResult<List<AmazingItem>>>

    @GET("getBestsellerProducts")
    suspend fun getBestSellerItems(): Response<ResponseResult<List<BestSellerItem>>>

    @GET("getMostVisitedProducts")
    suspend fun getMostVisitedItems(): Response<ResponseResult<List<MostVisitedItem>>>

    @GET("getSuperMarketAmazingProducts")
    suspend fun getSuperMarketItems(): Response<ResponseResult<List<AmazingItem>>>

    @GET("getSlider")
    suspend fun getSlider(): Response<ResponseResult<List<Slider>>>

    @GET("get4Banners")
    suspend fun getProposalBanners(): Response<ResponseResult<List<Slider>>>

    @GET("getSubCategories")
    suspend fun getSubCategories(): Response<ResponseResult<SubCategory>>
}