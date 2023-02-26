package com.example.person_list.di

import androidx.lifecycle.ViewModel

internal class PersonListComponentViewModel : ViewModel() {
    val newPersonListComponent =
        DaggerPersonListComponent.builder()
            .dependencies(PersonListDependenciesProvider.dependencies)
            .build()
}

interface PersonListDependenciesProvider{
    val dependencies: PersonListDependencies
    companion object: PersonListDependenciesProvider by PersonListDependenciesStore
}

object PersonListDependenciesStore: PersonListDependenciesProvider{
    override lateinit var dependencies: PersonListDependencies
}