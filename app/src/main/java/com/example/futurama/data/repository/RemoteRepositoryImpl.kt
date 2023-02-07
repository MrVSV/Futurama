package com.example.futurama.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.example.futurama.data.api.ApiPerson
import com.example.futurama.data.dto.PersonDto
import com.example.futurama.data.local.PersonDao
import com.example.futurama.data.local.entity.PersonEntity
import com.example.futurama.domain.model.Person
import com.example.futurama.domain.repository.RemoteRepository
import com.example.futurama.domain.tools.toListPerson
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


