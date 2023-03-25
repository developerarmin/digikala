package ir.truelearn.androidmvvmsample.repository

import ir.truelearn.androidmvvmsample.data.model.category.MainCategory
import ir.truelearn.androidmvvmsample.data.model.home.*
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

    suspend fun getCenterBannerItems(): NetworkResult<List<CenterBannerItem>> =
        safeApiCall {
            api.getCenterBanners()
        }
    suspend fun getMostFavoriteProducts(): NetworkResult<List<FavoriteProduct>> =
        safeApiCall {
            api.getMostFavoriteProducts()
        }

    suspend fun searchProduct(q:String) : NetworkResult<List<SearchProductsModel>> =
        safeApiCall {
            api.searchProduct(q)
        }

    suspend fun searchProductByBrand(q1:String,q2:String,q3:String) : NetworkResult<List<SearchProductsModel>> =
        safeApiCall {
            api.searchProductByBrand(q1,q2,q3)
        }
}