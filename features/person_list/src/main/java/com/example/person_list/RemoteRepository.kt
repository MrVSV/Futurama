package com.example.person_list



interface RemoteRepository {

    suspend fun getPersonList(): List<Person>

}