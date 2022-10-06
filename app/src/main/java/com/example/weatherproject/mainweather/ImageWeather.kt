package com.example.weatherproject.mainweather

import com.example.weatherproject.R

fun String.imageWeather(): Int {
    return when (this) {
        "01d" -> R.drawable.sun
        "02d" -> R.drawable.sun
        "03d" -> R.drawable.sun
        "04d" -> R.drawable.sun
        "09d" -> R.drawable.rain
        "10d" -> R.drawable.rain
        "11d" -> R.drawable.thunder
        "13d" -> R.drawable.sun
        "50d" -> R.drawable.sun
        "01n" -> R.drawable.sun
        "02n" -> R.drawable.sun
        "03n" -> R.drawable.sun
        "04n" -> R.drawable.sun
        "09n" -> R.drawable.rain
        "10n" -> R.drawable.rain
        "11n" -> R.drawable.thunder
        "13n" -> R.drawable.sun
        "50n" -> R.drawable.sun
        else -> R.drawable.ic_baseline_error_24
    }
}

