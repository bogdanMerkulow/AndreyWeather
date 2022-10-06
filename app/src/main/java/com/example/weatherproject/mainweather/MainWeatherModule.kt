package com.example.weatherproject.mainweather

import androidx.lifecycle.ViewModel
import com.example.weatherproject.common.api.WeatherApi
import com.example.weatherproject.common.network.NetworkModule
import com.example.weatherproject.mainweather.repository.MainWeatherPreviewRepository
import com.example.weatherproject.mainweather.repository.MainWeatherRepository
import com.example.weatherproject.mainweather.repository.MainWeatherRepositoryImpl
import com.example.weatherproject.mainweather.usecase.GetWeatherDataUseCase
import com.example.weatherproject.mainweather.usecase.GetWeatherDataUseCaseImpl
import com.example.weatherproject.mainweather.usecase.GetWeatherPreviewDataUseCase
import com.example.weatherproject.mainweather.usecase.GetWeatherPreviewDataUseCaseImpl
import com.example.weatherproject.mainweather.viewmodel.MainWeatherViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Singleton


@Module(includes = [NetworkModule::class])
class MainWeatherModule {

    @Provides
    fun provideRepository(weatherApi: WeatherApi): MainWeatherRepository =
        MainWeatherRepositoryImpl(weatherApi)

    @Provides
    fun providePreviewRepository(weatherApi: WeatherApi): MainWeatherPreviewRepository =
        MainWeatherRepositoryImpl(weatherApi)

    @Provides
    @Singleton
    fun weatherEventBus() = BehaviorSubject.create<Int>()

    @Provides
    fun provideUseCase(mainWeatherRepository: MainWeatherRepository): GetWeatherDataUseCase =
        GetWeatherDataUseCaseImpl(mainWeatherRepository)

    @Provides
    fun providePreviewUseCase(mainWeatherPreviewRepository: MainWeatherPreviewRepository):
            GetWeatherPreviewDataUseCase =
        GetWeatherPreviewDataUseCaseImpl(mainWeatherPreviewRepository)


    @Provides
    @IntoMap
    @ClassKey(MainWeatherViewModel::class)
    fun getViewModelMainWeather(
        getWeatherDataUseCase: GetWeatherDataUseCase,
        getWeatherPreviewDataUseCase: GetWeatherPreviewDataUseCase,
        weatherEventBus: BehaviorSubject<Int>
    ): ViewModel {
        return MainWeatherViewModel(
            getWeatherDataUseCase,
            getWeatherPreviewDataUseCase,
            weatherEventBus
        )
    }
}