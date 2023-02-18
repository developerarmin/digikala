package ir.truelearn.androidmvvmsample.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.truelearn.androidmvvmsample.data.model.checkout.CartAddress
import kotlinx.coroutines.flow.Flow


@Dao
interface AddressDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewAddress(address: CartAddress)

    @Query("select * from address")
    fun getAllAddress(): Flow<List<CartAddress>>

}