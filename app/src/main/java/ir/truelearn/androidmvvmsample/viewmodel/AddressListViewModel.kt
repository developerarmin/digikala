package ir.truelearn.androidmvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.address.UserAddressRequest
import ir.truelearn.androidmvvmsample.data.model.address.UserAddressResponse
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.repository.AddressRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddressListViewModel @Inject constructor(private val repository: AddressRepository) :
    ViewModel() {
    val defaultAddress = MutableStateFlow<UserAddressResponse?>(null)
    val defaultAddressTemp = MutableStateFlow<UserAddressResponse?>(null)

    val userAddressList =
        MutableStateFlow<NetworkResult<List<UserAddressResponse>>>(NetworkResult.Loading())

    fun getAddressList(tokenBody: String) {
        viewModelScope.launch {
            userAddressList.emit(repository.getUserAddress(tokenBody))
        }
    }




    fun setDefaultAddress(userAddress: UserAddressResponse) {
        defaultAddress.value = UserAddressResponse(
            _id = userAddress._id,
            address = userAddress.address,
            name = userAddress.name,
            phone = userAddress.phone,
            postalCode = userAddress.postalCode,
            userId = userAddress.userId,
            __v = userAddress.__v,
            createdAt = userAddress.createdAt,
            updatedAt = userAddress.updatedAt
        )
    }

    fun addNewAddress(userAddress: UserAddressRequest) {
        viewModelScope.launch(Dispatchers.IO) {
//            saveAddressResponse.emit(repository.saveUserAddress(userAddress))
            repository.saveUserAddress(userAddress)
        }
    }
}