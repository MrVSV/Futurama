package com.example.futurama.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

//class BaseViewModelFactory @Inject constructor(
//    private val viewModelFactories:
//    Map<Class<out com.example.core.base.BaseViewModel>, @JvmSuppressWildcards Provider<com.example.core.base.BaseViewModel>>
//) : ViewModelProvider.Factory {
//
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return viewModelFactories.getValue(modelClass as Class<com.example.core.base.BaseViewModel>).get() as T
//    }
//}
