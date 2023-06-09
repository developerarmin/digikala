package ir.truelearn.androidmvvmsample.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.basket.*
import ir.truelearn.androidmvvmsample.data.model.home.MostDiscountedItem
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.repository.CartRepository
import ir.truelearn.androidmvvmsample.util.DigitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val repository: CartRepository) : ViewModel() {


    val cartDetail = MutableStateFlow(CartDetail(0, 0, 0, 0))
    private val orderProducts: ArrayList<OrderProduct> = ArrayList()
    val currentCartItems: Flow<List<CartItem>> = repository.currentCartItems
    val nextCartItems: Flow<List<CartItem>> = repository.nextCartItems
    var currentCartItemsCount = repository.currentCartItemsCount
    var nextCartItemsCount = repository.nextCartItemsCount
    var digiKlabScore by mutableStateOf("150")


    //    var currentCartCount: Flow<Int> = repository.cartItemCounter
    var nextCartCount: Flow<Int> = repository.nextCartItemsCount


    val suggestedList =
        MutableStateFlow<NetworkResult<List<MostDiscountedItem>>>(NetworkResult.Loading())

    init {
        viewModelScope.launch {
            currentCartItems.collectLatest { items ->
                calculateAndDisplayDetailCart(items)
                setOrderList(items)
            }

        }
    }

    fun getSuggestedList() {
        viewModelScope.launch {
            suggestedList.emit(repository.getSuggestedItems())
        }
    }


    fun addItemToCart(cart: CartItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addItemToCart(cart)
        }
    }


    fun removeFromCart(item: CartItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeFromItem(item)
        }
    }

    fun clearShoppingCart() {
        viewModelScope.launch {
            repository.clearShoppingCart()
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

    private suspend fun calculateAndDisplayDetailCart(items: List<CartItem>) {
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


    fun setOrderList(products: List<CartItem>) {
        products.forEach { item ->
            orderProducts.add(
                OrderProduct(
                    count = item.count,
                    discountPercent = item.discountPercent,
                    image = item.image,
                    name = item.name,
                    price = item.price,
                    productId = item.itemID,
                    seller = item.seller
                )
            )
        }
    }

    fun getOrderList(): List<OrderProduct> {
        return orderProducts
    }

    val orderResponse =
        MutableStateFlow<NetworkResult<String>?>(null)

    val purchaseResponse =
        MutableStateFlow<NetworkResult<String?>?>(null)

    fun addNewOrder(cartOrderDetail: OrderDetail) {
        Log.d("level8", "addNewOrder: start from view model")
        viewModelScope.launch(Dispatchers.IO) {
            launch {
                orderResponse.emit(repository.setNewOrder(cartOrderDetail))
            }
        }
    }

    var orderDetail = mutableStateOf<OrderDetail?>(null)
    fun confirmPurchase(confirmPurchase: ConfirmPurchase) {
        viewModelScope.launch(Dispatchers.IO) {
            launch {
                purchaseResponse.emit(repository.confirmPurchase(confirmPurchase))
            }
        }
    }
}


