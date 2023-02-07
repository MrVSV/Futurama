package com.example.futurama.domain.repository

import com.example.futurama.domain.model.Person

interface LocalRepository {

    suspend fun addToFavorite(person: Person)

    suspend fun deleteFromFavorite(person: Person)


}