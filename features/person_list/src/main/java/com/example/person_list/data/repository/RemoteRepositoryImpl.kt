package com.example.person_list.data.repository


import com.example.api.api.ApiPerson
import com.example.api.local.PersonDao
import com.example.core.model.Person
import com.example.core.tools.toListPerson
import com.example.person_list.domain.repository.RemoteRepository
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


