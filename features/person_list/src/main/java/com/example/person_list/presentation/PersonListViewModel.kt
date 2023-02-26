package com.example.person_list.presentation

import androidx.lifecycle.viewModelScope
import com.example.core.base.BaseViewModel
import com.example.core.model.Person
import com.example.core.tools.LoadState
import com.example.person_list.domain.usecase.AddToFavoriteUseCase
import com.example.person_list.domain.usecase.DeleteFromFavoriteUseCase
import com.example.person_list.domain.usecase.GetPersonListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PersonListViewModel @Inject constructor(
    private val getPersonListUseCase: GetPersonListUseCase,
    private val addToFavoriteUseCase: AddToFavoriteUseCase,
    private val deleteFromFavoriteUseCase: DeleteFromFavoriteUseCase
) : BaseViewModel() {

    private val _personList = MutableStateFlow<List<Person>>(emptyList())
    val personList = _personList.asStateFlow()

    init {
        getPersonList()
    }

    private fun getPersonList() {
        viewModelScope.launch(Dispatchers.IO) {
            _loadState.value = LoadState.LOADING_STAGE_1
            _personList.value = getPersonListUseCase.getPersonList()
            _loadState.value = LoadState.SUCCESS
        }
    }

    fun onClick(person: Person, position: Int) {
        when (person.isFavorite) {
            false -> like(person, position)
            true -> disLike(person, position)
        }
    }

    private fun like(person: Person, position: Int) {
        viewModelScope.launch(Dispatchers.IO) {
//            person.isFavorite = true
            try {
                addToFavoriteUseCase.addToFavorite(person)
                _personList.value[position].isFavorite = true
            } catch (t: Throwable) {
                _loadState.value = LoadState.ERROR
            }

        }
    }

    private fun disLike(person: Person, position: Int) {
        viewModelScope.launch(Dispatchers.IO) {
//            person.isFavorite = false
            try {
                deleteFromFavoriteUseCase.deleteFromFavorite(person)
                _personList.value[position].isFavorite = false
            } catch (t: Throwable) {
                _loadState.value = LoadState.ERROR
            }

        }
    }
}