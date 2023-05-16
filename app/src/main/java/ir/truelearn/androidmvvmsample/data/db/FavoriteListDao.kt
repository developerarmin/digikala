package ir.truelearn.androidmvvmsample.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.*
import ir.truelearn.androidmvvmsample.data.model.profile.FavItem
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteListDao {

    @Query(" SELECT * FROM favorite_list_table ")
    fun getAllFavoriteItems(): Flow<List<FavItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoriteItem(favItem: FavItem)

    @Delete
    suspend fun removeFavoriteItem(favItem: FavItem)

    @Query(" DELETE FROM favorite_list_table ")
    suspend fun clearFavoriteList()

    @Query(" SELECT EXISTS(SELECT * FROM favorite_list_table WHERE id = :itemId) ")
    fun isFavoriteItemExist(itemId: String): Flow<Boolean>
}
