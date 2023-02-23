package com.example.data_base.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class PersonEntity(
    @PrimaryKey
    @ColumnInfo(name = "person_id")
    var id: Int,
    @ColumnInfo(name = "name")
    var name: String
)