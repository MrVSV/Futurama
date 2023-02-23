package com.example.person_list.di

import com.example.api.ApiPerson
import com.example.data_base.PersonDao

interface PersonListDependencies {

    val apiPerson: ApiPerson

    val personDao: PersonDao
}