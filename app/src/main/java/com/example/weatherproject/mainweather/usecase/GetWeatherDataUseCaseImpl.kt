package com.example.weatherproject.mainweather.usecase

import com.example.weatherproject.mainweather.dateFormatUnixTime
import com.example.weatherproject.mainweather.model.Weather
import com.example.weatherproject.mainweather.model.WeatherOverTimeData
import com.example.weatherproject.mainweather.model.WeatherPreviewData
import com.example.weatherproject.mainweather.model.toWeatherData
import com.example.weatherproject.mainweather.repository.MainWeatherRepository
import io.reactivex.Single

class GetWeatherDataUseCaseImpl(
    private val mainWeatherRepository: MainWeatherRepository
) : GetWeatherDataUseCase {

    private val weatherDays = mutableMapOf<String, MutableList<WeatherOverTimeData>>()

    override operator fun invoke(): Single<Weather> {
        return mainWeatherRepository.getWeatherWeekAndOverTime().map {

            it.forEach {
                if (weatherDays[it.dt.dateFormatUnixTime()] != null)
                    weatherDays[it.dt.dateFormatUnixTime()]?.add(it)
                else weatherDays[it.dt.dateFormatUnixTime()] = mutableListOf(it)
            }
            val weatherDataWithOutLastElement = weatherDays.toWeatherData().toMutableList()
            weatherDataWithOutLastElement.removeLast()
            weatherDataWithOutLastElement
            Weather(
                weatherDataWithOutLastElement, WeatherPreviewData(
                    weatherDataWithOutLastElement.first().dt,
                    weatherDataWithOutLastElement.first().icon,
                    weatherDataWithOutLastElement.first().temp,
                    weatherDataWithOutLastElement.first().description
                )
            )
        }
    }
}



