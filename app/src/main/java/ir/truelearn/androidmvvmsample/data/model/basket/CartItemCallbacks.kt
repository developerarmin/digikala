package ir.truelearn.androidmvvmsample.data.model.basket

import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus

interface CartItemCallbacks {
    fun onRemoveCartItem(cart: CartItem)
    fun onIncreaseCartItem(itemID: String, newCount: Int)
    fun onDecreaseCartItem(itemID: String, newCount: Int)
    fun onChangeStatusCart(itemID: String, newStatus: CartStatus)
}