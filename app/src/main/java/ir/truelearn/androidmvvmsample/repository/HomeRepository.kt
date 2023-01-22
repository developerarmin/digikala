package ir.truelearn.androidmvvmsample.repository

import ir.truelearn.androidmvvmsample.data.model.AmazingItem
import ir.truelearn.androidmvvmsample.data.model.Banners
import ir.truelearn.androidmvvmsample.data.model.Slider
import ir.truelearn.androidmvvmsample.data.remote.ApiInterface
import ir.truelearn.androidmvvmsample.data.remote.BaseApiResponse
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: ApiInterface) : BaseApiResponse() {

    suspend fun getAmazingItems(): NetworkResult<List<AmazingItem>> =
        safeApiCall {
            api.getAmazingItems()
        }
    suspend fun getSlider(): NetworkResult<List<Slider>> =
        safeApiCall {
            api.getSlider()
        }
    suspend fun getProposalBanners(): NetworkResult<List<Banners>> =
        safeApiCall {
            api.getProposalBanners()
        }
    suspend fun getSuperMarketItems(): NetworkResult<List<AmazingItem>> =
        safeApiCall {
            api.getSuperMarketItems()
        }
}