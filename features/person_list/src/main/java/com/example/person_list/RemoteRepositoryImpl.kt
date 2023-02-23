package com.example.person_list

import com.example.api.ApiPerson
import com.example.data_base.PersonDao
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val apiPerson: ApiPerson,
    private val personDao: PersonDao
) : RemoteRepository {

    override suspend fun getPersonList(): List<Person> {
        val api = apiPerson.getCharacters()
        val db = personDao.getFavorites()
        api.forEach { a ->
            for (b in db) {
                if (a.id == b.id) {
                    a.isFavorite = true
                    break
                }
            }
        }
        return api.toListPerson()
    }
}


