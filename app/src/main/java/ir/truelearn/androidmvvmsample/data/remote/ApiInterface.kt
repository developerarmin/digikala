package ir.truelearn.androidmvvmsample.data.remote

import ir.truelearn.androidmvvmsample.data.model.UserAddressRequest
import ir.truelearn.androidmvvmsample.data.model.*
import ir.truelearn.androidmvvmsample.data.model.basket.CartOrderDetail
import ir.truelearn.androidmvvmsample.data.model.category.MainCategory
import ir.truelearn.androidmvvmsample.data.model.category.SubCategory
import ir.truelearn.androidmvvmsample.data.model.home.*
import ir.truelearn.androidmvvmsample.data.model.login.LoginRequest
import ir.truelearn.androidmvvmsample.data.model.login.LoginResponse
import ir.truelearn.androidmvvmsample.data.model.product_detail.ProductDetailModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
    @GET("getAmazingProducts")
    suspend fun getAmazingItems(): Response<ResponseResult<List<AmazingItem>>>

    @GET("getBestsellerProducts")
    suspend fun getBestSellerItems(): Response<ResponseResult<List<BestItem>>>

    @GET("getMostVisitedProducts")
    suspend fun getMostVisitedItems(): Response<ResponseResult<List<BestItem>>>

    @GET("getSuperMarketAmazingProducts")
    suspend fun getSuperMarketItems(): Response<ResponseResult<List<AmazingItem>>>

    @GET("getSlider")
    suspend fun getSlider(): Response<ResponseResult<List<Slider>>>

    @GET("get4Banners")
    suspend fun getProposalBanners(): Response<ResponseResult<List<Slider>>>

    @GET("getSubCategories")
    suspend fun getSubCategories(): Response<ResponseResult<SubCategory>>

    @GET("getMostDiscountedProducts")
    suspend fun getMostDiscountedItems(): Response<ResponseResult<List<MostDiscountedItem>>>

    @GET("getCategories")
    suspend fun getCategories(): Response<ResponseResult<List<MainCategory>>>

    @GET("getCenterBanners")
    suspend fun getCenterBanners(): Response<ResponseResult<List<CenterBannerItem>>>

    @POST("login")
    suspend fun login(
        @Body login: LoginRequest
    ): Response<ResponseResult<LoginResponse>>

    @GET("getMostFavoriteProducts")
    suspend fun getMostFavoriteProducts(): Response<ResponseResult<List<FavoriteProduct>>>

    @GET("getAllProducts")
    suspend fun getSuggestedItems(): Response<ResponseResult<List<MostDiscountedItem>>>

    @GET("getProductById")
    suspend fun getProductById(
        @Query("id") id: String
    ): Response<ResponseResult<ProductDetailModel>>

    @GET("getUserAddress")
    suspend fun getUserAddressList(
        @Query("token") token: String
    ): Response<ResponseResult<List<UserAddressResponse>>>

    @POST("saveUserAddress")
    suspend fun saveUserAddress(
        @Body addressRequest: UserAddressRequest
    ): Response<ResponseResult<SaveAddressResponse>>


    @POST("setNewOrder")
    suspend fun setNewOrder(
        @Body orderRequest: CartOrderDetail
    ): Response<ResponseResult<SaveAddressResponse>>

}