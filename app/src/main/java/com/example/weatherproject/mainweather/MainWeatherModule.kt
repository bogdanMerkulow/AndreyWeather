package com.example.weatherproject.mainweather

import androidx.lifecycle.ViewModel
import com.example.weatherproject.common.api.WeatherApi
import com.example.weatherproject.common.network.NetworkModule
import com.example.weatherproject.mainweather.repository.MainWeatherRepository
import com.example.weatherproject.mainweather.repository.MainWeatherRepositoryImpl
import com.example.weatherproject.mainweather.usecase.GetWeatherDataUseCase
import com.example.weatherproject.mainweather.usecase.GetWeatherDataUseCaseImpl
import com.example.weatherproject.mainweather.viewmodel.MainWeatherViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module(includes = [NetworkModule::class])
class MainWeatherModule {

    @Provides
    fun provideRepository(weatherApi: WeatherApi): MainWeatherRepository =
        MainWeatherRepositoryImpl(weatherApi)

    @Provides
    fun provideUseCase(mainWeatherRepository: MainWeatherRepository): GetWeatherDataUseCase =
        GetWeatherDataUseCaseImpl(mainWeatherRepository)

    @Provides
    @IntoMap
    @ClassKey(MainWeatherViewModel::class)
    fun getViewModelMainWeather(getWeatherDataUseCase: GetWeatherDataUseCase): ViewModel {
        return MainWeatherViewModel(getWeatherDataUseCase)
    }
}