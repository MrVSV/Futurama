package com.example.futurama.domain.usecase

import com.example.futurama.domain.model.Person
import com.example.futurama.domain.repository.LocalRepository
import javax.inject.Inject

class AddToFavoriteUseCase @Inject constructor(
    private val localRepository: LocalRepository
) {

    suspend fun addToFavorite(person: Person){
        localRepository.addToFavorite(person)
    }
}