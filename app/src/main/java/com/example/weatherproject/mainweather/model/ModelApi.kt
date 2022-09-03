package com.example.weatherproject.mainweather.model

data class ModelApi(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<ModelDataApi>,
    val message: Int
)