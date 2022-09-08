package com.example.weatherproject.mainweather.model

data class WeatherData(
    val dt: Long,
    val temp: Double,
    val temp_min: Double,
    val temp_max: Double,
    val description: String,
    val icon: String,
    val listOverTimeData: List<WeatherOverTimeData>
)