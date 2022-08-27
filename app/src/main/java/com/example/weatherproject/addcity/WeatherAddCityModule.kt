package com.example.weatherproject.addcity

import androidx.lifecycle.ViewModel
import com.example.weatherproject.addcity.viewmodel.WeatherAddCityViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class WeatherAddCityModule {

    @Provides
    @IntoMap
    @ClassKey(WeatherAddCityViewModel::class)
    fun getViewModelWeatherAddCity(): ViewModel {
        return WeatherAddCityViewModel()
    }
}