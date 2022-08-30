package com.example.weatherproject.addcity.usecase

import com.example.weatherproject.addcity.model.WeatherAddCityData
import com.example.weatherproject.addcity.repository.WeatherAddCityRepository

class GetWeatherAddCityUseCase(
    private val weatherAddCityRepository: WeatherAddCityRepository
) {

    fun executeWeatherAddCity(): List<WeatherAddCityData> {
        return weatherAddCityRepository.getWeatherAddCity()
    }
}