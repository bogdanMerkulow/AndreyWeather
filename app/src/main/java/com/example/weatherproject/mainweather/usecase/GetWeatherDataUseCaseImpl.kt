package com.example.weatherproject.mainweather.usecase

import com.example.weatherproject.mainweather.dateFormatUnixTime
import com.example.weatherproject.mainweather.model.WeatherData
import com.example.weatherproject.mainweather.model.WeatherOverTimeData
import com.example.weatherproject.mainweather.model.toWeatherData
import com.example.weatherproject.mainweather.repository.MainWeatherRepository
import io.reactivex.Single

class GetWeatherDataUseCaseImpl(
    private val mainWeatherRepository: MainWeatherRepository
) : GetWeatherDataUseCase {

    private val weatherDays = mutableMapOf<String, MutableList<WeatherOverTimeData>>()

    override operator fun invoke(): Single<List<WeatherData>> {
        return mainWeatherRepository.getLoadWeatherWeekAndOverTime().map {

            it.forEach {
                if (weatherDays[it.dt.dateFormatUnixTime()] != null)
                    weatherDays[it.dt.dateFormatUnixTime()]?.add(it)
                else weatherDays[it.dt.dateFormatUnixTime()] = mutableListOf(it)
            }

            val weatherDataWithOutLastElement = weatherDays.toWeatherData().toMutableList()
            weatherDataWithOutLastElement.removeLast()
            weatherDataWithOutLastElement
        }
    }
}



