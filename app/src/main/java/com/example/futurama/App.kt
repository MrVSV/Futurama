package com.example.futurama

import android.app.Application
import android.content.Context
import com.example.futurama.di.AppComponent
import com.example.futurama.di.DaggerAppComponent

class App : Application(), AppDependencies {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appDeps(this)
            .build()

    }

    override val context: Context = this
}

interface AppDependencies {
    val context: Context
}