package com.example.futurama.data.repository

import com.example.futurama.data.local.PersonDao
import com.example.futurama.domain.model.Person
import com.example.futurama.domain.repository.LocalRepository
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val personDao: PersonDao
): LocalRepository {

    override suspend fun addToFavorite(person: Person) {
        personDao.insert(person.toPersonEntity())
    }

    override suspend fun deleteFromFavorite(person: Person) {
        personDao.delete(person.toPersonEntity())
    }
}