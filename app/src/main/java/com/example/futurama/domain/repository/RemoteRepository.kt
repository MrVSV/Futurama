package com.example.futurama.domain.repository

import com.example.core.model.Person

interface RemoteRepository {

    suspend fun getPersonList(): List<Person>

}