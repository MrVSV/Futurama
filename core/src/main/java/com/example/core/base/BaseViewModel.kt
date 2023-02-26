package com.example.core.base

import androidx.lifecycle.ViewModel
import com.example.core.tools.LoadState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel: ViewModel() {

    protected val _loadState =
        MutableStateFlow(LoadState.START)
    val loadState = _loadState.asStateFlow()

    protected val handler = CoroutineExceptionHandler { _, t ->
        _loadState.value = LoadState.ERROR
    }
}