package com.example.weatherproject.mainweather.model

sealed class State {
    object Loading : State()
    object Loaded : State()
    object Error : State()
}