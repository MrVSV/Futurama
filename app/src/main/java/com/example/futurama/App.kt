package com.example.futurama

import android.app.Application
import android.content.Context
import com.example.futurama.di.AppComponent
import com.example.futurama.di.DaggerAppComponent
import com.example.person_list.di.PersonListDependenciesStore

class App : Application(), AppDependencies {

    lateinit var appComponent: AppComponent
    override val context: Context = this

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appDependencies(this).build()
        PersonListDependenciesStore.dependencies = appComponent
    }
}

interface AppDependencies {
    val context: Context
}