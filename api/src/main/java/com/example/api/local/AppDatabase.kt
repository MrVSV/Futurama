package com.example.api.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.api.local.entity.PersonEntity

@Database(entities = [PersonEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getPersonDao(): PersonDao
}