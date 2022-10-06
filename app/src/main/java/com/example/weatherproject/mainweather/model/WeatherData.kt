package com.example.weatherproject.mainweather.model

data class WeatherData(
    val dt: Long,
    val temp: Double,
    val temp_min: Double,
    val temp_max: Double,
    val icon: String,
    val listOverTimeData: List<WeatherOverTimeData>,
)

fun Map<String, List<WeatherOverTimeData>>.toWeatherData() =
    this.map {
        WeatherData(
            it.value.first().dt,
            it.value.first().temp,
            it.value.first().temp_min,
            it.value.first().temp_max,
            it.value.first().icon,
            it.value
        )
    }
