package com.example.person_list.di

import com.example.core.ComponentViewModel
import com.example.core.DiComponent

class PersonListComponentViewModel: ComponentViewModel() {

    override val moduleComponent = DaggerPersonListComponent
        .builder()
        .dependencies

}