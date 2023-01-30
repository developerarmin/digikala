package ir.truelearn.androidmvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.datastore.DataStoreRepository
import ir.truelearn.androidmvvmsample.util.Constants.USER_ID
import ir.truelearn.androidmvvmsample.util.Constants.USER_LANGUAGE
import ir.truelearn.androidmvvmsample.util.Constants.USER_PASSWORD
import ir.truelearn.androidmvvmsample.util.Constants.USER_PHONE
import ir.truelearn.androidmvvmsample.util.Constants.USER_TOKEN
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
            repository.putString(USER_TOKEN, value)
        }
    }

    fun getUserToken(): String? = runBlocking {
        repository.getString(USER_TOKEN)
    }

    fun saveUserId(value: String) {
        viewModelScope.launch {
            repository.putString(USER_ID, value)
        }
    }

    fun getUserId(): String? = runBlocking {
        repository.getString(USER_ID)
    }

    fun saveUserPhoneNumber(value: String) {
        viewModelScope.launch {
            repository.putString(USER_PHONE, value)
        }
    }

    fun getUserPhoneNumber(): String? = runBlocking {
        repository.getString(USER_PHONE)
    }

    fun saveUserPassword(value: String) {
        viewModelScope.launch {
            repository.putString(USER_PASSWORD, value)
        }
    }

    fun getUserPassword(): String? = runBlocking {
        repository.getString(USER_PASSWORD)
    }

    fun saveUserLanguage(value: String) {
        viewModelScope.launch {
            repository.putString(USER_LANGUAGE, value)
        }
    }

    fun getUserLanguage(): String? = runBlocking {
        repository.getString(USER_LANGUAGE)
    }
}