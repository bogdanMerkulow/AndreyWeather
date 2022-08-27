package com.example.weatherproject.common.application

import android.app.Application

class MainApp : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}