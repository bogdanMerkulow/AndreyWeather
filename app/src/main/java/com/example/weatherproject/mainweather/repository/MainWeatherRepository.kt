package com.example.weatherproject.mainweather.repository

import com.example.weatherproject.mainweather.model.WeatherDataApi
import com.example.weatherproject.mainweather.model.WeatherPreviewData
import io.reactivex.Single

interface MainWeatherRepository {

    fun getWeatherWeekAndOverTime(): Single<List<WeatherDataApi>>
    fun getWeatherPreview(): Single<WeatherPreviewData>
    fun getLoadWeatherWeekAndOverTime(): Single<List<WeatherDataApi>>
    fun getLoadWeatherPreview(): Single<WeatherPreviewData>

}