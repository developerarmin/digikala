package ir.truelearn.androidmvvmsample.ui.component

import android.util.Log
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.viewmodel.DataStoreViewModel
import ir.truelearn.androidmvvmsample.viewmodel.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AutoLoginUser(
    viewModel: LoginViewModel = hiltViewModel(),
    dataStore: DataStoreViewModel = hiltViewModel()
) {

    LaunchedEffect(Dispatchers.Main) {

        val phone = dataStore.getUserPhoneNumber()
        val password = dataStore.getUserPassword()

        if (phone != null && password != null) {
            viewModel.autoLogin(phone, password)
            viewModel.loginResponse.collectLatest { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        result.data?.let {
                            if (it.role == "user" && it.token.isNotEmpty()) {
                                dataStore.saveUserToken(it.token)
                                dataStore.saveUserId(it.id)
                                dataStore.saveUserPhoneNumber(it.phone)
                                dataStore.saveUserPassword(password)
                            }
                        }
                    }
                    else -> {}
                }
            }
        }

    }
}