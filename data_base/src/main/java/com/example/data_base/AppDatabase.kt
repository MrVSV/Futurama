package com.example.data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data_base.entity.PersonEntity

@Database(entities = [PersonEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getPersonDao(): PersonDao
}