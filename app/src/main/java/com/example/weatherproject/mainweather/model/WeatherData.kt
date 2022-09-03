package com.example.weatherproject.mainweather.model

import com.example.weatherproject.mainweather.item.WeatherOverTimeItem
import io.reactivex.Single

data class WeatherData(
    val temp: String,
    val temp_min: String,
    val temp_max: String,
    val description: String,
//    val icon: String,
    val dt_txt: String,
    val list: List<WeatherOverTimeData>

)