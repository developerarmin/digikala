package ir.truelearn.androidmvvmsample.repository

import ir.truelearn.androidmvvmsample.data.model.category.SubCategory
import ir.truelearn.androidmvvmsample.data.model.home.AmazingItem
import ir.truelearn.androidmvvmsample.data.model.home.BestSellerItem
import ir.truelearn.androidmvvmsample.data.model.home.Slider
import ir.truelearn.androidmvvmsample.data.remote.ApiInterface
import ir.truelearn.androidmvvmsample.data.remote.BaseApiResponse
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val api: ApiInterface) : BaseApiResponse() {

    suspend fun getSubCategories(): NetworkResult<SubCategory> =
        safeApiCall {
            api.getSubCategories()
        }

}