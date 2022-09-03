package com.example.weatherproject.mainweather.model

data class ModelDataApi (
    val clouds: Clouds,
    val dt: Int,
    val dt_txt: String,
    val main: WeatherDataApi,
    val pop: Double,
    val rain: Rain,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)