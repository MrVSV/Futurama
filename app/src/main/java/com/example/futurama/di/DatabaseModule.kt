package com.example.futurama.di

import android.content.Context
import androidx.room.Room
import com.example.futurama.data.local.AppDatabase
import com.example.futurama.data.local.PersonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun providePhotosDao(appDatabase: AppDatabase): PersonDao {
        return appDatabase.getPersonDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext, AppDatabase::class.java, "db"
        ).build()
    }
}