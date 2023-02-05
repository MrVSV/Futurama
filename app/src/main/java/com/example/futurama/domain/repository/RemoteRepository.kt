package com.example.futurama.domain.repository

import com.example.futurama.domain.model.Person

interface RemoteRepository {

    suspend fun getPersonList(): List<Person>

}