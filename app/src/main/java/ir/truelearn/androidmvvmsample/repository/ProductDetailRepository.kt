package ir.truelearn.androidmvvmsample.repository

import ir.truelearn.androidmvvmsample.data.model.home.FavoriteProduct
import ir.truelearn.androidmvvmsample.data.model.home.Slider
import ir.truelearn.androidmvvmsample.data.remote.ApiInterface
import ir.truelearn.androidmvvmsample.data.remote.BaseApiResponse
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import javax.inject.Inject

class ProductDetailRepository @Inject constructor(private val api: ApiInterface) : BaseApiResponse() {
    suspend fun getSlider(): NetworkResult<List<Slider>> =
        safeApiCall {
            api.getSlider()
        }
}