package com.example.weatherproject.mainweather.repository

import com.example.weatherproject.common.api.WeatherApi
import com.example.weatherproject.mainweather.model.WeatherOverTimeData
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainWeatherRepositoryImpl(private val weatherApi: WeatherApi) : MainWeatherRepository {

    override fun getWeatherWeekAndOverTime(): Single<List<WeatherOverTimeData>> {
        val response = weatherApi.getWeatherData()
        return response.map {
            it.list.map {
                WeatherOverTimeData(
                    it.dt,
                    it.main.temp,
                    it.main.temp_min,
                    it.main.temp_max,
                    it.weather.first().description,
                    it.weather.first().icon
                )
            }
        }
    }

    override fun getLoadWeatherWeekAndOverTime(): Single<List<WeatherOverTimeData>> {
        return getWeatherWeekAndOverTime()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}

