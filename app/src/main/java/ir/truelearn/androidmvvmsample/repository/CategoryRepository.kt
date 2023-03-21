package ir.truelearn.androidmvvmsample.repository

import ir.truelearn.androidmvvmsample.data.model.category.BrandsCategory
import ir.truelearn.androidmvvmsample.data.model.category.MainCategory
import ir.truelearn.androidmvvmsample.data.model.category.SubCategory
import ir.truelearn.androidmvvmsample.data.remote.ApiInterface
import ir.truelearn.androidmvvmsample.data.remote.BaseApiResponse
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val api: ApiInterface) : BaseApiResponse() {

    suspend fun getSubCategories(): NetworkResult<SubCategory> =
        safeApiCall {
            api.getSubCategories()
        }
    suspend fun getBrandsCategory(): NetworkResult<BrandsCategory> =
        safeApiCall {
            api.getBrandsCategory()
        }


}