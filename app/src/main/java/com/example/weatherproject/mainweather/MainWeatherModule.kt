package com.example.weatherproject.mainweather

import androidx.lifecycle.ViewModel
import com.example.weatherproject.common.api.BASE_URL
import com.example.weatherproject.common.api.WeatherApi
import com.example.weatherproject.common.network.NetworkModule
import com.example.weatherproject.mainweather.repository.MainWeatherPreviewRepository
import com.example.weatherproject.mainweather.repository.MainWeatherRepository
import com.example.weatherproject.mainweather.repository.MainWeatherRepositoryImpl
import com.example.weatherproject.mainweather.usecase.GetWeatherDataUseCase
import com.example.weatherproject.mainweather.usecase.GetWeatherPreviewDataUseCase
import com.example.weatherproject.mainweather.viewmodel.MainWeatherViewModel
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import io.reactivex.subjects.BehaviorSubject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module(includes = [NetworkModule::class])
class MainWeatherModule {

    @Provides
    fun provideApi(retrofit: Retrofit): WeatherApi = retrofit.create(WeatherApi::class.java)

    @Provides
    fun provideRepository(weatherApi: WeatherApi): MainWeatherRepository =
        MainWeatherRepositoryImpl(weatherApi)

    @Provides
    fun providePreviewRepository(weatherApi: WeatherApi): MainWeatherPreviewRepository =
        MainWeatherRepositoryImpl(weatherApi)

    @Provides
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun weatherEventBus() = BehaviorSubject.create<Int>()

    @Provides
    fun provideUseCase(mainWeatherRepository: MainWeatherRepository): GetWeatherDataUseCase =
        GetWeatherDataUseCase(mainWeatherRepository)

    @Provides
    fun providePreviewUseCase(mainWeatherPreviewRepository: MainWeatherPreviewRepository):
            GetWeatherPreviewDataUseCase =
        GetWeatherPreviewDataUseCase(mainWeatherPreviewRepository)


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