package com.example.weatherproject.common.context

import android.content.Context
import com.example.weatherproject.common.application.AppComponent
import com.example.weatherproject.common.application.MainApp

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> this.applicationContext.appComponent
    }