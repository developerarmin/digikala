package ir.truelearn.androidmvvmsample.repository

import ir.truelearn.androidmvvmsample.data.db.FavoriteListDao
import ir.truelearn.androidmvvmsample.data.model.profile.FavItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteListRepository @Inject constructor(
    private val favoriteListDao: FavoriteListDao
) {
    val allFavoriteItems : Flow<List<FavItem>> = favoriteListDao.getAllFavoriteItems()

    suspend fun addFavoriteItem(favItem:FavItem) {
        favoriteListDao.addFavoriteItem(favItem)
    }

    suspend fun removeFavoriteItem(favItem: FavItem){
        favoriteListDao.removeFavoriteItem(favItem)
    }

    suspend fun clearFavoriteList(){
        favoriteListDao.clearFavoriteList()
    }

    fun isFavoriteItemExist(itemId:String) : Flow<Boolean>{
        return favoriteListDao.isFavoriteItemExist(itemId)
    }
}
