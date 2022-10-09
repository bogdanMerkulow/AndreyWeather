package com.example.weatherproject.mainweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherproject.common.rx.plusAssign
import com.example.weatherproject.mainweather.model.State
import com.example.weatherproject.mainweather.model.WeatherData
import com.example.weatherproject.mainweather.model.WeatherPreviewData
import com.example.weatherproject.mainweather.usecase.GetWeatherDataUseCase
import io.reactivex.disposables.CompositeDisposable

class MainWeatherViewModel(
    private val getWeatherDataUseCase: GetWeatherDataUseCase,
) : ViewModel() {

    private val _weatherWeek: MutableLiveData<List<WeatherData>> = MutableLiveData()
    val weatherWeek: LiveData<List<WeatherData>> get() = _weatherWeek

    private val _weatherPreview: MutableLiveData<WeatherPreviewData> = MutableLiveData()
    val weatherPreview: LiveData<WeatherPreviewData> get() = _weatherPreview

    private var _screenState: MutableLiveData<State> = MutableLiveData()
    val screenState: LiveData<State> get() = _screenState

    private val compositeDisposable = CompositeDisposable()

    fun loadWeather() {
        _screenState.postValue(State.Loading)
        compositeDisposable += getWeatherDataUseCase()
            .subscribe({
                _weatherWeek.postValue(it.weather)
                _weatherPreview.postValue(it.weatherPreview)
                _screenState.postValue(State.Loaded)
            }, {
                _screenState.postValue(State.Error)
            })
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}



