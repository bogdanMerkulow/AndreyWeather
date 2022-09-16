package com.example.weatherproject.mainweather.usecase

import com.example.weatherproject.mainweather.dateFormat
import com.example.weatherproject.mainweather.model.WeatherPreviewData
import com.example.weatherproject.mainweather.repository.MainWeatherPreviewRepository
import io.reactivex.Single

class GetWeatherPreviewDataUseCase(
    private val mainWeatherPreviewRepository: MainWeatherPreviewRepository
) {

    private val weatherPreview = mutableMapOf<String, MutableList<WeatherPreviewData>>()

    fun executeWeatherPreview(): Single<List<WeatherPreviewData>> {
        return mainWeatherPreviewRepository.getLoadWeatherPreview().map {
            it.forEach {
                if (weatherPreview[it.dt.dateFormat()] != null)
                    weatherPreview[it.dt.dateFormat()]?.add(it)
                else weatherPreview[it.dt.dateFormat()] = mutableListOf()
            }
            weatherPreview.map {
                WeatherPreviewData(
                    it.value.first().dt,
                    it.value.first().icon,
                    it.value.first().temp,
                    it.value.first().description
                )
            }
        }
    }
}