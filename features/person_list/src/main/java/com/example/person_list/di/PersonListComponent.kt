package com.example.person_list.di

import androidx.lifecycle.ViewModelProvider
import com.example.core.DiComponent
import com.example.person_list.RepositoryModule
import dagger.Component

@Component(dependencies = [PersonListDependencies::class], modules = [RepositoryModule::class])
interface PersonListComponent : DiComponent {

    override val viewModelFactory: ViewModelProvider.Factory


    @Component.Builder
    interface Builder {

        fun dependencies(personListDependencies: PersonListDependencies): Builder
        fun build(): PersonListComponent

    }
}