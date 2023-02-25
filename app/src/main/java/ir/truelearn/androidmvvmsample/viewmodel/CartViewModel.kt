package ir.truelearn.androidmvvmsample.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.address.UserAddressResponse
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

    private val orderProducts: ArrayList<OrderProduct> = ArrayList()
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


    fun addNewOrder(cartOrderDetail: OrderDetail) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.setNewOrder(cartOrderDetail)
        }
    }


    //===========================================================================================

    var GetOrderState  = mutableStateOf(false)

    val orderId = mutableStateOf("")
    val transactionId=mutableStateOf("")

    val userOrderList =
        MutableStateFlow<NetworkResult<List<UserOrdersResponse>>>(NetworkResult.Loading())

    fun getUserOrderList(tokenBody: String) {
        viewModelScope.launch {
            userOrderList.emit(repository.getUserOrders(tokenBody))
        }
    }

}


