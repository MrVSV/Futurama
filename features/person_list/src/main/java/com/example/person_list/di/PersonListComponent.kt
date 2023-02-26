package com.example.person_list.di

import com.example.core.base.BaseViewModelFactory
import com.example.person_list.presentation.PersonListFragment
import dagger.Component

@Component(dependencies = [PersonListDependencies::class])
internal interface PersonListComponent {

    val factory: BaseViewModelFactory

    fun inject(personListFragment: PersonListFragment)

    @Component.Builder
    interface Builder{
        fun dependencies(personListDependencies: PersonListDependencies): Builder
        fun build(): PersonListComponent
    }
}