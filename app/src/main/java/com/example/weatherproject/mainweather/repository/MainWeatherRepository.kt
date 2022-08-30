package com.example.weatherproject.mainweather.repository

import com.example.weatherproject.mainweather.model.WeatherData
import com.example.weatherproject.mainweather.model.WeatherPreviewData

interface MainWeatherRepository {

    fun getWeatherWeekAndOverTime(): List<WeatherData>
    fun getWeatherPreview(): WeatherPreviewData
}