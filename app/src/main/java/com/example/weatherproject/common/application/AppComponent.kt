package com.example.weatherproject.common.application

import androidx.lifecycle.ViewModelProvider
import com.example.weatherproject.common.module.FeaturesModule
import com.example.weatherproject.common.viewmodel.ViewModelModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        FeaturesModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {
    fun getViewModelFactory(): ViewModelProvider.Factory
}