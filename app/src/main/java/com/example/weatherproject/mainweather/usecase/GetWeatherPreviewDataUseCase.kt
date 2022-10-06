package com.example.weatherproject.mainweather.usecase

import com.example.weatherproject.mainweather.model.WeatherPreviewData
import io.reactivex.Single

interface GetWeatherPreviewDataUseCase {

    operator fun invoke(): Single<List<WeatherPreviewData>>

}