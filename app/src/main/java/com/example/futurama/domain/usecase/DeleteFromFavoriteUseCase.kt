package com.example.futurama.domain.usecase

import com.example.futurama.domain.model.Person
import com.example.futurama.domain.repository.LocalRepository
import javax.inject.Inject

class DeleteFromFavoriteUseCase @Inject constructor(
    private val localRepository: LocalRepository
) {

    suspend fun deleteFromFavorite(person: Person){
        return localRepository.deleteFromFavorite(person)
    }
}