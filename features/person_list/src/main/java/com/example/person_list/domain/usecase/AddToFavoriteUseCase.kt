package com.example.person_list.domain.usecase

import com.example.core.model.Person
import com.example.person_list.domain.repository.LocalRepository
import javax.inject.Inject

class AddToFavoriteUseCase @Inject constructor(
    private val localRepository: LocalRepository
) {

    suspend fun addToFavorite(person: Person){
        localRepository.addToFavorite(person)
    }
}