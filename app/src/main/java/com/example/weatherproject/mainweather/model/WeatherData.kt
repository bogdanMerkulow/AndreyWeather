package com.example.weatherproject.mainweather.model

data class WeatherData(
    val day: String,
    val week: String,
    val minTemp: String,
    val maxTemp: String,
    val weatherOverTimeData: List<WeatherOverTimeData>
)
