package com.example.person_list.domain.repository

import com.example.core.model.Person

interface LocalRepository {

    suspend fun addToFavorite(person: Person)

    suspend fun deleteFromFavorite(person: Person)


}