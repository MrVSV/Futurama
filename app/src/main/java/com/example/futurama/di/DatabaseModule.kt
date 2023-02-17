package com.example.futurama.di

import android.content.Context
import androidx.room.Room
import com.example.futurama.data.local.AppDatabase
import com.example.futurama.data.local.PersonDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun providePhotosDao(appDatabase: AppDatabase): PersonDao {
        return appDatabase.getPersonDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context, AppDatabase::class.java, "db"
        ).build()
    }
}