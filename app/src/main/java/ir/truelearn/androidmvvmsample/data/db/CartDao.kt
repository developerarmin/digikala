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
    suspend fun changeCountCartItem(id: Int, newCount: Int): Int

    @Query("update shopping_cart set cartStatus=:newStatus where itemID=:itemID")
    suspend fun changeStatusCart(itemID: Int, newStatus: CartStatus): Int

    @Query("select *from shopping_cart")
    fun getAllItems(): Flow<List<CartItem>>
    @Query("select *from shopping_cart where cartStatus=:status")
    fun getAllItems(status:CartStatus): Flow<List<CartItem>>
}