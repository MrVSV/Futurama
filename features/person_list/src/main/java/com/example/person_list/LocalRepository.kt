package com.example.person_list

interface LocalRepository {

    suspend fun addToFavorite(person: Person)

    suspend fun deleteFromFavorite(person: Person)


}