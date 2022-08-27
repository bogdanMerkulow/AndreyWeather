package com.example.weatherproject.mainweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherproject.mainweather.model.WeatherData
import com.example.weatherproject.mainweather.repository.MainWeatherRepository

class MainWeatherViewModel(private val mainWeatherRepository: MainWeatherRepository) : ViewModel() {

    private val _model: MutableLiveData<List<WeatherData>> = MutableLiveData()
    val model: LiveData<List<WeatherData>> get() = _model

}