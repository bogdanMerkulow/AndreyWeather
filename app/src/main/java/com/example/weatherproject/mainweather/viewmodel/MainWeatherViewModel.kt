package com.example.weatherproject.mainweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherproject.mainweather.model.WeatherData
import com.example.weatherproject.mainweather.usecase.GetWeatherDataUseCase

class MainWeatherViewModel(
    private val getWeatherDataUseCase: GetWeatherDataUseCase
) : ViewModel() {

    private val _resultWeatherWeek: MutableLiveData<List<WeatherData>> = MutableLiveData()
    val resultWeatherWeek: LiveData<List<WeatherData>> get() = _resultWeatherWeek

    fun loadWeatherWeekAndOverTime() =
        _resultWeatherWeek.postValue(getWeatherDataUseCase.executeWeatherWeekAndOverTime())

}



