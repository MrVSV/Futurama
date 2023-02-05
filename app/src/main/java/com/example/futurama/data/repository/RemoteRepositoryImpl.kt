package com.example.futurama.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.example.futurama.data.api.ApiPerson
import com.example.futurama.domain.model.Person
import com.example.futurama.domain.repository.RemoteRepository
import com.example.futurama.domain.tools.toListPerson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val apiPerson: ApiPerson
): RemoteRepository {

    private val remoteRepositoryScope = CoroutineScope(Dispatchers.IO)

    override suspend fun getPersonList(): List<Person> {
        Log.d(TAG, "getPersonList: ${apiPerson.getCharacters().toListPerson()}")
        return apiPerson.getCharacters().toListPerson()
    }

}