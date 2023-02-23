package com.example.person_list.di

interface PersonListDependenciesProvider {

    val dependencies: PersonListDependencies

    companion object: PersonListDependenciesProvider by PersonListStore
}