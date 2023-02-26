package com.example.person_list.domain.usecase

import com.example.person_list.domain.repository.RemoteRepository
import javax.inject.Inject

class GetPersonListUseCase @Inject constructor(
    private val remoteRepository: RemoteRepository
) {

    suspend fun getPersonList() = remoteRepository.getPersonList()
}