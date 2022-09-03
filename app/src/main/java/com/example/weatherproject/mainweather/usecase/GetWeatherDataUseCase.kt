package com.example.weatherproject.mainweather.usecase

import com.example.weatherproject.mainweather.model.WeatherData
import com.example.weatherproject.mainweather.repository.MainWeatherRepository
import io.reactivex.Single

class GetWeatherDataUseCase(
    private val mainWeatherRepository: MainWeatherRepository
) {

    fun executeWeatherWeekAndOverTime(): Single<List<WeatherData>> {
        return mainWeatherRepository.getLoadWeatherWeekAndOverTime()
    }
//    fun executeWeatherWeekAndOverTime(): WeatherData {
//        return mainWeatherRepository.getWeatherWeekAndOverTime()
//    }

//    fun executeWeatherPreview(): Single<WeatherPreviewData> {
//        return mainWeatherRepository.getLoadWeatherPreview()
//    }

}