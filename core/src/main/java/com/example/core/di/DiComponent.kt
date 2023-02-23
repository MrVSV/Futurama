package com.example.core.di

import androidx.lifecycle.ViewModelProvider

interface DiComponent {

    val viewModelFactory: ViewModelProvider.Factory
}