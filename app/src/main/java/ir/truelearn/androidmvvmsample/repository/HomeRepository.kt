package ir.truelearn.androidmvvmsample.repository

import ir.truelearn.androidmvvmsample.data.model.category.MainCategory
import ir.truelearn.androidmvvmsample.data.model.home.MostDiscountedItem
import ir.truelearn.androidmvvmsample.data.model.home.AmazingItem
import ir.truelearn.androidmvvmsample.data.model.home.BestItem
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

    suspend fun getBestSellerItems(): NetworkResult<List<BestItem>> =
        safeApiCall {
            api.getBestSellerItems()
        }
    suspend fun getMostVisitedItems(): NetworkResult<List<BestItem>> =
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

    suspend fun getMostDiscountedItems(): NetworkResult<List<MostDiscountedItem>> =
        safeApiCall {
            api.getMostDiscountedItems()
        }

    suspend fun getCategories(): NetworkResult<List<MainCategory>> =
        safeApiCall {
            api.getCategories()
        }
}