package ir.truelearn.androidmvvmsample.repository

import ir.truelearn.androidmvvmsample.data.remote.ApiInterface
import ir.truelearn.androidmvvmsample.data.remote.BaseApiResponse
import javax.inject.Inject

class ProductDetailRepository @Inject constructor(private val api: ApiInterface) : BaseApiResponse() {
}