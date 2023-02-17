package com.example.futurama

import android.app.Application
import com.example.futurama.di.AppComponent
import com.example.futurama.di.AppModule
import com.example.futurama.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()

    }
}