package com.example.core.di

import androidx.lifecycle.ViewModel

abstract class ComponentViewModel: ViewModel(){

    abstract val moduleComponent: DiComponent

}