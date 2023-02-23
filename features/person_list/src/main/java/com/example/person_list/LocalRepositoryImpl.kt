package com.example.person_list


import com.example.data_base.PersonDao
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