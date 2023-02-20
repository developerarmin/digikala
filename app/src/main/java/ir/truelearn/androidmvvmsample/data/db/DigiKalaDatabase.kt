package ir.truelearn.androidmvvmsample.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem

@Database(entities = [CartItem::class], version = 1, exportSchema = false)
abstract class DigiKalaDatabase : RoomDatabase() {
    abstract fun CartDao(): CartDao
}