package com.example.weatherproject.mainweather.repository

import com.example.weatherproject.mainweather.model.WeatherData
import com.example.weatherproject.mainweather.model.WeatherNetworkResponse
import io.reactivex.Single

interface MainWeatherRepository {

    fun getWeatherWeekAndOverTime(): Single<List<WeatherData>>
    fun getLoadWeatherWeekAndOverTime(): Single<List<WeatherData>>


    //    fun getWeatherPreview(): Single<WeatherPreviewData>
//    fun getLoadWeatherPreview(): Single<WeatherPreviewData>

}