package com.example.weatherproject.mainweather

import androidx.lifecycle.ViewModel
import com.example.weatherproject.mainweather.repository.MainWeatherRepository
import com.example.weatherproject.mainweather.repository.MainWeatherRepositoryImpl
import com.example.weatherproject.mainweather.usecase.GetWeatherDataUseCase
import com.example.weatherproject.mainweather.viewmodel.MainWeatherViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module
class MainWeatherModule {

    @Provides
    fun provideUseCase(mainWeatherRepository: MainWeatherRepository) : GetWeatherDataUseCase =
        GetWeatherDataUseCase(mainWeatherRepository)

    @Provides
    fun provideRepository() : MainWeatherRepository = MainWeatherRepositoryImpl()

    @Provides
    @IntoMap
    @ClassKey(MainWeatherViewModel::class)
    fun getViewModelMainWeather(getWeatherDataUseCase: GetWeatherDataUseCase): ViewModel {
        return MainWeatherViewModel(getWeatherDataUseCase)
    }
}