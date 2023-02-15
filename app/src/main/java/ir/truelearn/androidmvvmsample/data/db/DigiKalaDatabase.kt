package ir.truelearn.androidmvvmsample.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.truelearn.androidmvvmsample.data.model.basket.CartItem
import ir.truelearn.androidmvvmsample.data.model.checkout.CartAddress

@Database(entities = [CartItem::class,CartAddress::class], version = 1, exportSchema = false)
abstract class DigiKalaDatabase : RoomDatabase() {
    abstract fun CartDao(): CartDao
    abstract fun AddressDao(): AddressDao
}