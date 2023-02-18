package ir.truelearn.androidmvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus
import ir.truelearn.androidmvvmsample.data.model.checkout.CartAddress
import ir.truelearn.androidmvvmsample.repository.AddressRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddressViewModel @Inject constructor(private val repository: AddressRepository) : ViewModel() {

    val getAllAddress: Flow<List<CartAddress>> = repository.getAllAddress

    fun addNewAddress(address: CartAddress) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNewAddress(address)
        }
    }
}