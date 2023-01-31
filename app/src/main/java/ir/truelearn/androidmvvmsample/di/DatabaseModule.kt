package ir.truelearn.androidmvvmsample.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.truelearn.androidmvvmsample.data.db.CartDao
import ir.truelearn.androidmvvmsample.data.db.DigiKalaDatabase
import ir.truelearn.androidmvvmsample.util.Constants.DATABASE_NAME
import javax.inject.Singleton

@Module()
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        DigiKalaDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideCartDao(database: DigiKalaDatabase):CartDao = database.CartDao()
}