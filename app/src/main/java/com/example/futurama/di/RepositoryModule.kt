package com.example.futurama.di

import com.example.person_list.data.repository.LocalRepositoryImpl
import com.example.person_list.data.repository.RemoteRepositoryImpl
import com.example.person_list.domain.repository.LocalRepository
import com.example.person_list.domain.repository.RemoteRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindRemoteRepository(
        RemoteRepository: RemoteRepositoryImpl
    ): RemoteRepository

    @Binds
    abstract fun bindLocalRepository(
        localRepository: LocalRepositoryImpl
    ): LocalRepository
}