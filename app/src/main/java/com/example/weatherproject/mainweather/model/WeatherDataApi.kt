package com.example.weatherproject.mainweather.model

data class WeatherDataApi(
    val feels_like: Double,
    val grnd_level: Int,
    val humidity: String,
    val pressure: Int,
    val sea_level: Int,
    val temp_kf: Double,
    val message: Int,
    val temp_max: Double,
    val temp_min: Double,
    val list: List<WeatherOverTimeData>,

    )