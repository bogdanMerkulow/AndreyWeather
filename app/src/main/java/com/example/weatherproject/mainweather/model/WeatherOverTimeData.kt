package com.example.weatherproject.mainweather.model

data class WeatherOverTimeData(
    val dt: Long,
    val temp: Double,
    val temp_min: Double,
    val temp_max: Double,
    val icon: String,
)
