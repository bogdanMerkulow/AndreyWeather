package com.example.weatherproject.mainweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherproject.mainweather.model.WeatherData
import com.example.weatherproject.mainweather.model.WeatherPreviewData
import com.example.weatherproject.mainweather.usecase.GetWeatherDataUseCase

class MainWeatherViewModel(
    private val getWeatherDataUseCase: GetWeatherDataUseCase
) : ViewModel() {

    private val _resultWeatherWeek: MutableLiveData<List<WeatherData>> = MutableLiveData()
    val resultWeatherWeek: LiveData<List<WeatherData>> get() = _resultWeatherWeek

    private val _resultWeatherPreview: MutableLiveData<WeatherPreviewData> = MutableLiveData()
    val resultWeatherPreview: LiveData<WeatherPreviewData> = _resultWeatherPreview

    private val _resultTempPreview: MutableLiveData<WeatherPreviewData> = MutableLiveData()
    val resultTempPreview: LiveData<WeatherPreviewData> = _resultTempPreview

    private val _resultFeelingTempPreview: MutableLiveData<WeatherPreviewData> = MutableLiveData()
    val resultFeelingTempPreview: LiveData<WeatherPreviewData> = _resultFeelingTempPreview

    fun loadWeatherWeekAndOverTime() =
        _resultWeatherWeek.postValue(getWeatherDataUseCase.executeWeatherWeekAndOverTime())

    fun loadWeatherPreview() =
        _resultWeatherPreview.postValue(getWeatherDataUseCase.executeWeatherPreview())

    fun loadWeatherTempPreview() =
        _resultTempPreview.postValue(getWeatherDataUseCase.executeWeatherPreview())

    fun loadWeatherFeelingTempPreview() =
        _resultFeelingTempPreview.postValue(getWeatherDataUseCase.executeWeatherPreview())
}



