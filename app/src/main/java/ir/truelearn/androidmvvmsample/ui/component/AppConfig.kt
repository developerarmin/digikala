package ir.truelearn.androidmvvmsample.ui.component

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import ir.truelearn.androidmvvmsample.MainActivity
import ir.truelearn.androidmvvmsample.MainActivity.Companion.USER_ID
import ir.truelearn.androidmvvmsample.MainActivity.Companion.USER_LANGUAGE
import ir.truelearn.androidmvvmsample.MainActivity.Companion.USER_PASSWORD
import ir.truelearn.androidmvvmsample.MainActivity.Companion.USER_PHONE
import ir.truelearn.androidmvvmsample.MainActivity.Companion.USER_TOKEN
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.viewmodel.DataStoreViewModel
import ir.truelearn.androidmvvmsample.viewmodel.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AppConfig(
    viewModel: LoginViewModel = hiltViewModel(),
    dataStore: DataStoreViewModel = hiltViewModel()
) {

    getDataStoreVariables(dataStore)

    LaunchedEffect(Dispatchers.Main) {
        if (USER_PHONE != "null" && USER_PASSWORD != "null")
            viewModel.autoLogin(USER_PHONE, USER_PASSWORD)
        viewModel.loginResponse.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    result.data?.let {
                        if (it.role == "user" && it.token.isNotEmpty()) {
                            dataStore.saveUserToken(it.token)
                            dataStore.saveUserId(it.id)
                            dataStore.saveUserPhoneNumber(it.phone)
                            dataStore.saveUserPassword(USER_PASSWORD)
                            getDataStoreVariables(dataStore)
                        }
                    }
                }
                else -> {}
            }
        }
    }
}

private fun getDataStoreVariables(dataStore: DataStoreViewModel) {
    USER_TOKEN = dataStore.getUserToken().toString()
    USER_ID = dataStore.getUserId().toString()
    USER_PHONE = dataStore.getUserPhoneNumber().toString()
    USER_PASSWORD = dataStore.getUserPassword().toString()
    USER_LANGUAGE = dataStore.getUserLanguage()
    Log.d("level12", "token:${USER_TOKEN} ")
}