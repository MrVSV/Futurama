package com.example.futurama.domain.usecase

import com.example.futurama.domain.repository.RemoteRepository
import javax.inject.Inject

class GetPersonListUseCase @Inject constructor(
    private val remoteRepository: RemoteRepository
) {

    suspend fun getPersonList() = remoteRepository.getPersonList()
}