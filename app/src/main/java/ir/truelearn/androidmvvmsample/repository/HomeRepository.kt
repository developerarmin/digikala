package ir.truelearn.androidmvvmsample.repository

import ir.truelearn.androidmvvmsample.data.model.home.AmazingItem
import ir.truelearn.androidmvvmsample.data.model.home.BestSellerItem
import ir.truelearn.androidmvvmsample.data.model.home.MostVisitedItem
import ir.truelearn.androidmvvmsample.data.model.home.Slider
import ir.truelearn.androidmvvmsample.data.remote.ApiInterface
import ir.truelearn.androidmvvmsample.data.remote.BaseApiResponse
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: ApiInterface) : BaseApiResponse() {

    suspend fun getAmazingItems(): NetworkResult<List<AmazingItem>> =
        safeApiCall {
            api.getAmazingItems()
        }

    suspend fun getBestSellerItems(): NetworkResult<List<BestSellerItem>> =
        safeApiCall {
            api.getBestSellerItems()
        }
    suspend fun getMostVisitedItems(): NetworkResult<List<MostVisitedItem>> =
        safeApiCall {
            api.getMostVisitedItems()
        }

    suspend fun getSlider(): NetworkResult<List<Slider>> =
        safeApiCall {
            api.getSlider()
        }

    suspend fun getProposalBanners(): NetworkResult<List<Slider>> =
        safeApiCall {
            api.getProposalBanners()
        }

    suspend fun getSuperMarketItems(): NetworkResult<List<AmazingItem>> =
        safeApiCall {
            api.getSuperMarketItems()
        }
}