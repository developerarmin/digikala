package ir.truelearn.androidmvvmsample.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.PersonInfo
import ir.truelearn.androidmvvmsample.data.model.basket.CartDetail
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus
import ir.truelearn.androidmvvmsample.data.model.basket.TokenBody
import ir.truelearn.androidmvvmsample.data.model.home.MostDiscountedItem
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.repository.CartRepository
import ir.truelearn.androidmvvmsample.util.DigitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val repository: CartRepository) : ViewModel() {



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


    val cartDetail = MutableStateFlow(CartDetail(0, 0, 0, 0))

    val currentCartItems: Flow<List<CartItem>> = repository.currentCartItems
    val nextCartItems: Flow<List<CartItem>> = repository.nextCartItems
    var currentCartItemsCount = repository.currentCartItemsCount
    var nextCartItemsCount = repository.nextCartItemsCount
    var digiKlabScore by mutableStateOf("150")



    //    var currentCartCount: Flow<Int> = repository.cartItemCounter
    var nextCartCount: Flow<Int> = repository.nextCartItemsCount


    val suggestedList =
        MutableStateFlow<NetworkResult<List<MostDiscountedItem>>>(NetworkResult.Loading())

    val personInfoList =
        MutableStateFlow<NetworkResult<List<PersonInfo>>>(NetworkResult.Loading())

    init {
        viewModelScope.launch {
            calculateAndDisplayDetailCart()
        }
    }

    fun getSuggestedList() {
        viewModelScope.launch {
            suggestedList.emit(repository.getSuggestedItems())
        }
    }

    fun getUserAddress(tokenBody: String) {
        viewModelScope.launch {
            personInfoList.emit(repository.getUserAddress(tokenBody))
        }
    }

    fun addNewItem(cart: CartItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNewItem(cart)
        }
    }


    fun removeFromCart(item: CartItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeFromItem(item)
        }
    }

    fun increaseCartItem(id: String, newCount: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.changeCountCartItem(id, newCount)
        }
    }

    fun decreaseCartItem(id: String, newCount: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.changeCountCartItem(id, newCount)
        }
    }

    fun changeStatusCart(itemID: String, newStatus: CartStatus) {
        viewModelScope.launch {
            repository.changeStatusCart(itemID, newStatus)
        }
    }

    private suspend fun calculateAndDisplayDetailCart() {
        currentCartItems.collectLatest { items ->
            var totalPrice = 0
            var discount = 0
            var payablePrice = 0
            items.forEach { item ->
                totalPrice += item.price * item.count
                discount += item.discountPercent
            }
            payablePrice = DigitHelper.applyDiscount(totalPrice, discount)
            cartDetail.value = CartDetail(totalPrice, 0, discount, payablePrice)
        }
    }
}


