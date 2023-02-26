package com.example.person_list.domain.usecase

import com.example.core.model.Person
import com.example.person_list.domain.repository.LocalRepository
import javax.inject.Inject

class DeleteFromFavoriteUseCase @Inject constructor(
    private val localRepository: LocalRepository
) {

    suspend fun deleteFromFavorite(person: Person){
        return localRepository.deleteFromFavorite(person)
    }
}