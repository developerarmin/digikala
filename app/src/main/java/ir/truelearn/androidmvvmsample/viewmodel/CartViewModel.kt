package ir.truelearn.androidmvvmsample.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.basket.CartDetail
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus
import ir.truelearn.androidmvvmsample.data.model.home.MostDiscountedItem
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.repository.CartRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val repository: CartRepository) : ViewModel() {
    val cartDetail = MutableStateFlow(CartDetail(0, 0, 0))

    val currentCartItems: Flow<List<CartItem>> = repository.currentCartItems
    val nextCartItems: Flow<List<CartItem>> = repository.nextCartItems
    var currentCartItemsCount = repository.currentCartItemsCount
    var nextCartItemsCount = repository.nextCartItemsCount
//    var currentCartCount: Flow<Int> = repository.cartItemCounter
    var nextCartCount: Flow<Int> = repository.nextCartItemsCount



    val suggestedList =
        MutableStateFlow<NetworkResult<List<MostDiscountedItem>>>(NetworkResult.Loading())

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
            var payablePrice = 0
            items.forEach { item ->
                totalPrice += item.price * item.count
                //todo This variable is set to true data
                val discountAmount = 0
                payablePrice += (item.price - discountAmount) * item.count
            }
            cartDetail.value = CartDetail(totalPrice, 0, payablePrice)
        }

    }

}
