package com.example.weatherproject.mainweather.usecase

import com.example.weatherproject.mainweather.model.WeatherDataApi
import com.example.weatherproject.mainweather.model.WeatherPreviewData
import com.example.weatherproject.mainweather.repository.MainWeatherRepository
import io.reactivex.Single

class GetWeatherDataUseCase(
    private val mainWeatherRepository: MainWeatherRepository
) {

    fun executeWeatherWeekAndOverTime(): Single<List<WeatherDataApi>> {
        return mainWeatherRepository.getLoadWeatherWeekAndOverTime()
    }

    fun executeWeatherPreview(): Single<WeatherPreviewData> {
        return mainWeatherRepository.getLoadWeatherPreview()
    }

}