package ir.truelearn.androidmvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.datastore.DataStoreRepository
import ir.truelearn.androidmvvmsample.util.Constants.USER_ID_KEY
import ir.truelearn.androidmvvmsample.util.Constants.USER_LANGUAGE_KEY
import ir.truelearn.androidmvvmsample.util.Constants.USER_PASSWORD_KEY
import ir.truelearn.androidmvvmsample.util.Constants.USER_PHONE_KEY
import ir.truelearn.androidmvvmsample.util.Constants.USER_TOKEN_KEY
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class DataStoreViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {


    fun saveUserToken(value: String) {
        viewModelScope.launch {
            repository.putString(USER_TOKEN_KEY, value)
        }
    }

    fun getUserToken(): String? = runBlocking {
        repository.getString(USER_TOKEN_KEY)
    }

    fun saveUserId(value: String) {
        viewModelScope.launch {
            repository.putString(USER_ID_KEY, value)
        }
    }

    fun getUserId(): String? = runBlocking {
        repository.getString(USER_ID_KEY)
    }

    fun saveUserPhoneNumber(value: String) {
        viewModelScope.launch {
            repository.putString(USER_PHONE_KEY, value)
        }
    }

    fun getUserPhoneNumber(): String? = runBlocking {
        repository.getString(USER_PHONE_KEY)
    }

    fun saveUserPassword(value: String) {
        viewModelScope.launch {
            repository.putString(USER_PASSWORD_KEY, value)
        }
    }

    fun getUserPassword(): String? = runBlocking {
        repository.getString(USER_PASSWORD_KEY)
    }

    fun saveUserLanguage(value: String) {
        viewModelScope.launch {
            repository.putString(USER_LANGUAGE_KEY, value)
        }
    }

    fun getUserLanguage(): String? = runBlocking {
        repository.getString(USER_LANGUAGE_KEY)
    }
}