package com.example.weatherproject.mainweather.repository

import com.example.weatherproject.mainweather.model.WeatherData

interface MainWeatherRepository {

    fun getWeatherWeekAndOverTime(): List<WeatherData>
}