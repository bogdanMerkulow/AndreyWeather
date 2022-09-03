package com.example.weatherproject.mainweather.model


data class WeatherData(

    val day: String,
    val temp_min: String,
    val temp_max: String,
    val description: String,
    val _url: String
) {
    val url: String get() = "$_url.png"
}



