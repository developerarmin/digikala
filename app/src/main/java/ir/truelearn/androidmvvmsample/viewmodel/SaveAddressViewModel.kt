package ir.truelearn.androidmvvmsample.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.SaveAddressResponse
import ir.truelearn.androidmvvmsample.data.model.UserAddressRequest
import ir.truelearn.androidmvvmsample.data.model.UserAddressResponse
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.repository.UserAddressRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaveAddressViewModel @Inject constructor(private val repository: UserAddressRepository) :
    ViewModel() {
    var ProvinceName = mutableStateOf("اردبیل")
    var CityName = mutableStateOf("اردبیل")
    var inputPostalAddress by mutableStateOf("")
    var inputNumber by mutableStateOf("")
    var inputUnit by mutableStateOf("")
    var inputPostalCode by mutableStateOf("")
    var dlgProvinceName = mutableStateOf("اردبیل")
    var dlgCityState = mutableStateOf(false)
    var dlgCityName = mutableStateOf("اردبیل")
    var inputPostalAddressState by mutableStateOf("")
    var inputNumberState by mutableStateOf("")
    var inputUnitState by mutableStateOf("")
    var inputZipCodeState by mutableStateOf("")
    var inputCheckboxState by mutableStateOf(false)
    var inputRecipientName by mutableStateOf("")
    var inputRecipientPhone by mutableStateOf("")



    val saveAddressResponse =
        MutableStateFlow<NetworkResult<SaveAddressResponse>>(NetworkResult.Loading())

    fun addNewAddress(userAddress: UserAddressRequest) {
        viewModelScope.launch(Dispatchers.IO) {
//            saveAddressResponse.emit(repository.saveUserAddress(userAddress))
            repository.saveUserAddress(userAddress)
        }
    }
}