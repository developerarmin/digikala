package ir.truelearn.androidmvvmsample.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.basket.CartStatus
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCartItem(cart: CartItem)

    @Delete
    suspend fun removeFromCart(cart: CartItem)

    @Query("update shopping_cart set count=:newCount where itemID=:id")
    suspend fun changeCountCartItem(id: String, newCount: Int): Int

    @Query("update shopping_cart set cartStatus=:newStatus where itemID=:itemID")
    suspend fun changeStatusCart(itemID: String, newStatus: CartStatus): Int

    @Query("select *from shopping_cart")
    fun getAllItems(): Flow<List<CartItem>>

    @Query("select *from shopping_cart where cartStatus=:status")
    fun getAllItems(status: CartStatus): Flow<List<CartItem>>

    @Query("select sum(count) as count from shopping_cart where cartStatus=:status")
    fun getCartItemsCount(status: CartStatus = CartStatus.CURRENT_CART): Flow<Int>

    @Query("select COUNT(itemID)  from shopping_cart where cartStatus =:status")
    fun getNextCartItemCounter(status: CartStatus = CartStatus.NEXT_CART): Flow<Int>


}