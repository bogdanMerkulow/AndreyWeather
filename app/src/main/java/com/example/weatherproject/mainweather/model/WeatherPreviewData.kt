package com.example.weatherproject.mainweather.model


data class WeatherPreviewData(

    val description: String,
    val feels_like: Double,
    val icon: String,
    val country: String,
    val id: Int,
    val temp: Double,
    val main: String


    )
