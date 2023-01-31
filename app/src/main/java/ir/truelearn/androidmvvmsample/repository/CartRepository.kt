package ir.truelearn.androidmvvmsample.repository

import ir.truelearn.androidmvvmsample.data.db.CartDao
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus
import javax.inject.Inject

class CartRepository @Inject constructor(private val cartDao: CartDao) {
    val currentCartItems = cartDao.getAllItems(CartStatus.CURRENT_CART)
    val nextCartItems = cartDao.getAllItems(CartStatus.NEXT_CART)
    suspend fun addNewItem(cart: CartItem) {
        cartDao.insertCartItem(cart)
    }

    suspend fun changeCountCartItem(id: Int, newCount: Int) {
        cartDao.changeCountCartItem(id, newCount)
    }

    suspend fun changeStatusCart(itemID: Int, newStatus: CartStatus) {
        cartDao.changeStatusCart(itemID, newStatus)
    }


    suspend fun removeFromItem(cart: CartItem) {
        cartDao.removeFromCart(cart)
    }
}