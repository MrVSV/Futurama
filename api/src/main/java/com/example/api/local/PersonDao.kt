package com.example.api.local

import androidx.room.*
import com.example.api.local.entity.PersonEntity

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(person: PersonEntity)

    @Query("SELECT * FROM person")
    fun getFavorites(): List<PersonEntity>

    @Query("DELETE FROM person")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(person: PersonEntity)

//    @Update
//    suspend fun updateLocalLikes(personEntity: PersonEntity)
//
//    @Transaction
//    suspend fun refresh(data: List<PersonEntity>){
//        deleteAll()
//        insert(data)
//    }


}