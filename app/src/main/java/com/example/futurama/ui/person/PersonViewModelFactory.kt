package com.example.futurama.ui.person

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.futurama.domain.usecase.AddToFavoriteUseCase
import com.example.futurama.domain.usecase.DeleteFromFavoriteUseCase
import com.example.futurama.domain.usecase.GetPersonListUseCase
import javax.inject.Inject

//class PersonViewModelFactory @Inject constructor(
//    private val getPersonListUseCase: GetPersonListUseCase,
//    private val addToFavoriteUseCase: AddToFavoriteUseCase,
//    private val deleteFromFavoriteUseCase: DeleteFromFavoriteUseCase
//) : ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return PersonViewModel(
//            getPersonListUseCase,
//            addToFavoriteUseCase,
//            deleteFromFavoriteUseCase
//        ) as T
//    }
//}