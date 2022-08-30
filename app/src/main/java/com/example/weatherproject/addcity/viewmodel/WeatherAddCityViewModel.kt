package com.example.weatherproject.addcity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherproject.addcity.model.WeatherAddCityData
import com.example.weatherproject.addcity.usecase.GetWeatherAddCityUseCase

class WeatherAddCityViewModel(
    private val getWeatherAddCityUseCase: GetWeatherAddCityUseCase
) : ViewModel() {

    private val _resultWeatherAddCity: MutableLiveData<List<WeatherAddCityData>> = MutableLiveData()
    val resultWeatherAddCity: LiveData<List<WeatherAddCityData>> = _resultWeatherAddCity

    fun loadWeatherAddCity() =
        _resultWeatherAddCity.postValue(getWeatherAddCityUseCase.executeWeatherAddCity())


}