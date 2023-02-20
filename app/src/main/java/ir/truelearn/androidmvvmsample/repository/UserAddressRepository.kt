package ir.truelearn.androidmvvmsample.repository

import ir.truelearn.androidmvvmsample.data.model.UserAddressRequest
import ir.truelearn.androidmvvmsample.data.model.UserAddressResponse
import ir.truelearn.androidmvvmsample.data.remote.ApiInterface
import ir.truelearn.androidmvvmsample.data.remote.BaseApiResponse
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import javax.inject.Inject


class UserAddressRepository @Inject constructor(private val api: ApiInterface) : BaseApiResponse() {


    suspend fun getUserAddress(token: String): NetworkResult<List<UserAddressResponse>> =
        safeApiCall {
            api.getUserAddressList(token)
        }

    suspend fun saveUserAddress(userAddressRequest: UserAddressRequest) =
        api.saveUserAddress(userAddressRequest)
//        safeApiCall {
//            api.saveUserAddress(userAddressRequest)
//        }


}