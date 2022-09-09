package com.example.weatherproject.mainweather.usecase

import com.example.weatherproject.mainweather.dateFormat
import com.example.weatherproject.mainweather.model.WeatherData
import com.example.weatherproject.mainweather.model.WeatherOverTimeData
import com.example.weatherproject.mainweather.repository.MainWeatherRepository
import io.reactivex.Single

class GetWeatherDataUseCase(private val mainWeatherRepository: MainWeatherRepository) {

    private val weatherDays = mutableMapOf<String, MutableList<WeatherOverTimeData>>()

    fun executeWeatherWeekAndOverTime(): Single<List<WeatherData>> {
        return mainWeatherRepository.getLoadWeatherWeekAndOverTime().map {
            it.forEach {
                if (weatherDays[it.dt.dateFormat()] != null)
                    weatherDays[it.dt.dateFormat()]?.add(it)
                else weatherDays[it.dt.dateFormat()] = mutableListOf()
            }
            weatherDays.map {
                WeatherData(
                    it.value.first().dt,
                    it.value.first().temp,
                    it.value.first().temp_min,
                    it.value.first().temp_max,
                    it.value.first().icon,
                    it.value
                )
            }
        }
    }
}



