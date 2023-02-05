package com.example.futurama.di

import com.example.futurama.data.repository.RemoteRepositoryImpl
import com.example.futurama.domain.repository.RemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindRemoteRepository(
        photoRemoteRepository: RemoteRepositoryImpl
    ): RemoteRepository
}