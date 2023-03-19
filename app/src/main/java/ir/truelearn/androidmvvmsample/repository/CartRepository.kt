package ir.truelearn.androidmvvmsample.repository

import ir.truelearn.androidmvvmsample.data.db.CartDao
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.basket.OrderDetail
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus
import ir.truelearn.androidmvvmsample.data.model.basket.ConfirmPurchase
import ir.truelearn.androidmvvmsample.data.model.home.MostDiscountedItem
import ir.truelearn.androidmvvmsample.data.remote.ApiInterface
import ir.truelearn.androidmvvmsample.data.remote.BaseApiResponse
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import javax.inject.Inject

class CartRepository @Inject constructor(
    private val api: ApiInterface,
    private val cartDao: CartDao
) : BaseApiResponse() {


    val currentCartItems = cartDao.getAllItems(CartStatus.CURRENT_CART)
    val nextCartItems = cartDao.getAllItems(CartStatus.NEXT_CART)

    val currentCartItemsCount = cartDao.getCartItemsCount()
    val nextCartItemsCount = cartDao.getNextCartItemCount()

    suspend fun addItemToCart(cart: CartItem) {
        cartDao.insertCartItem(cart)
    }

    suspend fun changeCountCartItem(id: String, newCount: Int) {
        cartDao.changeCountCartItem(id, newCount)
    }

    suspend fun changeStatusCart(itemID: String, newStatus: CartStatus) {
        cartDao.changeStatusCart(itemID, newStatus)
    }


    suspend fun removeFromItem(cart: CartItem) {
        cartDao.removeFromCart(cart)
    }

    suspend fun clearShoppingCart() {
        cartDao.clearShoppingCart()
    }


    suspend fun getSuggestedItems(): NetworkResult<List<MostDiscountedItem>> =
        safeApiCall {
            api.getSuggestedItems()
        }

    suspend fun setNewOrder(cartOrderDetail: OrderDetail): NetworkResult<String> =
        safeApiCall {
            api.setNewOrder(cartOrderDetail)
        }

    suspend fun confirmPurchase(confirmPurchase: ConfirmPurchase): NetworkResult<String?> =
        safeApiCall {
            api.confirmPurchase(confirmPurchase)
        }
}
