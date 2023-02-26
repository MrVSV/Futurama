package com.example.person_list.data.repository

import com.example.api.local.PersonDao
import com.example.core.model.Person
import com.example.person_list.domain.repository.LocalRepository
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