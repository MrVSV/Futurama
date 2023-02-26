package com.example.person_list.domain.repository

import com.example.core.model.Person

interface RemoteRepository {

    suspend fun getPersonList(): List<Person>

}