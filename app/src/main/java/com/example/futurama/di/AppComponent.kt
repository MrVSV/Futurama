package com.example.futurama.di

import com.example.futurama.ui.person.PersonFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    AppModule::class,
    ApiModule::class,
    DatabaseModule::class,
    RepositoryModule::class])
@Singleton
interface AppComponent {
    fun inject(personFragment: PersonFragment)
}
