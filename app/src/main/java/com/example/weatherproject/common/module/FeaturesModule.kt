package com.example.weatherproject.common.module

import com.example.weatherproject.addcity.WeatherAddCityModule
import com.example.weatherproject.common.application.ApplicationModule
import com.example.weatherproject.mainweather.MainWeatherModule
import dagger.Module


@Module(
    includes = [
        MainWeatherModule::class,
        WeatherAddCityModule::class,
        ApplicationModule::class
    ]
)
class FeaturesModule