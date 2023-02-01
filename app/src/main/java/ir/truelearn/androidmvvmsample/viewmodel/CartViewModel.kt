package ir.truelearn.androidmvvmsample.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.basket.CartDetail
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus
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
    var cartItemCounter = mutableStateOf(4)
    var nextCartItemCounter = mutableStateOf(3)

    init {

        viewModelScope.launch {
            calculateAndDisplayDetailCart()
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

    fun increaseCartItem(id: Int, newCount: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.changeCountCartItem(id, newCount)
        }
    }

    fun decreaseCartItem(id: Int, newCount: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.changeCountCartItem(id, newCount)
        }
    }

    fun changeStatusCart(itemID: Int, newStatus: CartStatus) {
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
