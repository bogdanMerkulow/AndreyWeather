package com.example.weatherproject.mainweather

import com.example.weatherproject.R

val String.imageWeather: Int
    get() = when (this) {
        "01d" -> R.drawable.sun
        "02d" -> R.drawable.thunder
        "03d" -> R.drawable.thunder
        "04d" -> R.drawable.thunder
        "10d" -> R.drawable.rain
        "01n" -> R.drawable.sun
        "02n" -> R.drawable.thunder
        "03n" -> R.drawable.thunder
        "04n" -> R.drawable.thunder
        "10n" -> R.drawable.rain
        else -> R.drawable.ic_baseline_error_24
    }

