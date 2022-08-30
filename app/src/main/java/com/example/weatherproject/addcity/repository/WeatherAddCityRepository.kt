package com.example.weatherproject.addcity.repository

import com.example.weatherproject.addcity.model.WeatherAddCityData

interface WeatherAddCityRepository {

    fun getWeatherAddCity(): List<WeatherAddCityData>
}