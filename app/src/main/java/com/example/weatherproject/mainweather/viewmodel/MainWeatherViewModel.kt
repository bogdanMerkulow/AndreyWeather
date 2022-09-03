package com.example.weatherproject.mainweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherproject.common.rx.plusAssign
import com.example.weatherproject.mainweather.model.WeatherDataApi
import com.example.weatherproject.mainweather.model.WeatherPreviewData
import com.example.weatherproject.mainweather.usecase.GetWeatherDataUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject

class MainWeatherViewModel(
    private val getWeatherDataUseCase: GetWeatherDataUseCase,
    private val weatherEventBus: BehaviorSubject<Int>
) : ViewModel() {

    private val _resultWeatherWeek: MutableLiveData<List<WeatherDataApi>> = MutableLiveData()
    val resultWeatherWeek: LiveData<List<WeatherDataApi>> get() = _resultWeatherWeek

    private val _resultWeatherPreview: MutableLiveData<WeatherPreviewData> = MutableLiveData()
    val resultWeatherPreview: LiveData<WeatherPreviewData> = _resultWeatherPreview

    private val _resultTempPreview: MutableLiveData<WeatherPreviewData> = MutableLiveData()
    val resultTempPreview: LiveData<WeatherPreviewData> = _resultTempPreview

    private val _resultFeelingTempPreview: MutableLiveData<WeatherPreviewData> = MutableLiveData()
    val resultFeelingTempPreview: LiveData<WeatherPreviewData> = _resultFeelingTempPreview

    private val _internetError: MutableLiveData<String> = MutableLiveData()
    val internetError: LiveData<String> get() = _internetError

    private val compositeDisposable = CompositeDisposable()


    fun loadWeatherWeekAndOverTime() {
        compositeDisposable += getWeatherDataUseCase.executeWeatherWeekAndOverTime()
            .subscribe({
                _resultWeatherWeek.postValue(it)
            }, {
                _internetError.postValue(it.message)
            })
    }

    fun loadWeatherPreview() {
        compositeDisposable += getWeatherDataUseCase.executeWeatherPreview()
            .subscribe({
                _resultWeatherPreview.postValue(it)
            }, {
                _internetError.postValue(it.message)
            })
    }

    fun loadWeatherTempPreview() {
        compositeDisposable += getWeatherDataUseCase.executeWeatherPreview()
            .subscribe({
                _resultTempPreview.postValue(it)
            }, {
                _internetError.postValue(it.message)
            })
    }

    fun loadWeatherFeelingTempPreview() {
        compositeDisposable += getWeatherDataUseCase.executeWeatherPreview()
            .subscribe({
                _resultFeelingTempPreview.postValue(it)
            }, {
                _internetError.postValue(it.message)
            })
    }
//    fun loadWeatherWeekAndOverTime() =
//        _resultWeatherWeek.postValue(getWeatherDataUseCase.executeWeatherWeekAndOverTime())

//    fun loadWeatherPreview() =
//        _resultWeatherPreview.postValue(getWeatherDataUseCase.executeWeatherPreview())
//
//    fun loadWeatherTempPreview() =
//        _resultTempPreview.postValue(getWeatherDataUseCase.executeWeatherPreview())
//
//    fun loadWeatherFeelingTempPreview() =
//        _resultFeelingTempPreview.postValue(getWeatherDataUseCase.executeWeatherPreview())
}



