package com.example.weatherproject.mainweather.usecase

import com.example.weatherproject.mainweather.model.WeatherData
import com.example.weatherproject.mainweather.model.WeatherPreviewData
import com.example.weatherproject.mainweather.repository.MainWeatherRepository

class GetWeatherDataUseCase(
    private val mainWeatherRepository: MainWeatherRepository
) {

    fun executeWeatherWeekAndOverTime(): List<WeatherData> {
        return mainWeatherRepository.getWeatherWeekAndOverTime()
    }

    fun executeWeatherPreview(): WeatherPreviewData {
        return mainWeatherRepository.getWeatherPreview()
    }
}