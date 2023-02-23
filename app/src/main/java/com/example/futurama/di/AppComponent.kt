package com.example.futurama.di

import com.example.api.ApiPerson
import com.example.data_base.PersonDao
import com.example.person_list.di.PersonListDependencies
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        ApiModule::class,
        DatabaseModule::class
    ]
)
@Singleton
interface AppComponent : PersonListDependencies {

    override val apiPerson: ApiPerson
    override val personDao: PersonDao

}


