package com.example.weatherproject.mainweather

import com.example.weatherproject.R

val String.imageWeather: Int
    get() = when (this) {
        "01d" -> R.drawable.sun
        "02d" -> R.drawable.rain
        "03d" -> R.drawable.rain
        "04d" -> R.drawable.rain
        "01n" -> R.drawable.sun
        "02n" -> R.drawable.rain
        "03n" -> R.drawable.rain
        "04n" -> R.drawable.rain
        else -> R.drawable.ic_baseline_error_24
    }

