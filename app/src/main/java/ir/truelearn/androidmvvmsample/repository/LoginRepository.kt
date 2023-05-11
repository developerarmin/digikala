package ir.truelearn.androidmvvmsample.repository

import ir.truelearn.androidmvvmsample.data.model.login.LoginRequest
import ir.truelearn.androidmvvmsample.data.model.login.LoginResponse
import ir.truelearn.androidmvvmsample.data.remote.ApiInterface
import ir.truelearn.androidmvvmsample.data.remote.BaseApiResponse
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: ApiInterface) : BaseApiResponse() {

    suspend fun login(loginRequest: LoginRequest): NetworkResult<LoginResponse> =
        safeApiCall {
            api.login(loginRequest)
        }

}