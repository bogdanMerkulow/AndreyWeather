package com.example.weatherproject.addcity

import androidx.lifecycle.ViewModel
import com.example.weatherproject.addcity.repository.WeatherAddCityRepository
import com.example.weatherproject.addcity.repository.WeatherAddCityRepositoryImpl
import com.example.weatherproject.addcity.usecase.GetWeatherAddCityUseCase
import com.example.weatherproject.addcity.viewmodel.WeatherAddCityViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class WeatherAddCityModule {

    @Provides
    fun provideRepositoryWeatherAddCity(): WeatherAddCityRepository = WeatherAddCityRepositoryImpl()

    @Provides
    fun provideUseCaseAddCity(weatherAddCityRepository: WeatherAddCityRepository):
            GetWeatherAddCityUseCase = GetWeatherAddCityUseCase(weatherAddCityRepository)

    @Provides
    @IntoMap
    @ClassKey(WeatherAddCityViewModel::class)
    fun getViewModelWeatherAddCity(getWeatherAddCityUseCase: GetWeatherAddCityUseCase): ViewModel {
        return WeatherAddCityViewModel(getWeatherAddCityUseCase)
    }
}