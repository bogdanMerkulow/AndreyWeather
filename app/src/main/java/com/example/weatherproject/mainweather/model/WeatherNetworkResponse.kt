package com.example.weatherproject.mainweather.model

data class WeatherNetworkResponse(
    val temp: String,
    val temp_min: String,
    val temp_max: String,
    val description: String,
    val icon: String,
    val dt_txt: String,
)
