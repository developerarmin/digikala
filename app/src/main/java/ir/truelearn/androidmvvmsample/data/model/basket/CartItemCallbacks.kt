package ir.truelearn.androidmvvmsample.data.model.basket

import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus

interface CartItemCallbacks {
    fun onRemoveCartItem(cart: CartItem)
    fun onIncreaseCartItem(itemID: Int, newCount: Int)
    fun onDecreaseCartItem(itemID: Int, newCount: Int)
    fun onChangeStatusCart(itemID: Int, newStatus: CartStatus)
}