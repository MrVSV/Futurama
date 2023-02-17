package com.example.futurama.di

import com.example.futurama.data.repository.LocalRepositoryImpl
import com.example.futurama.data.repository.RemoteRepositoryImpl
import com.example.futurama.domain.repository.LocalRepository
import com.example.futurama.domain.repository.RemoteRepository
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