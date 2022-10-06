package com.example.weatherproject.addcity.repository

import com.example.weatherproject.addcity.model.WeatherAddCityData

class WeatherAddCityRepositoryImpl : WeatherAddCityRepository {

    override fun getWeatherAddCity(): List<WeatherAddCityData> = testAddCity

}

private val testAddCity = listOf(
    WeatherAddCityData("Москва", "25°", "25°"),
    WeatherAddCityData("Санкт-Петербург", "25°", "25°"),
    WeatherAddCityData("Тамбов", "25 С", "25 С"),
    WeatherAddCityData("Воронеж", "25 С", "25 С"),
    WeatherAddCityData("Воронеж", "25 С", "25 С"),
    WeatherAddCityData("Воронеж", "25 С", "25 С"),
    WeatherAddCityData("Воронеж", "25 С", "25 С"),
    WeatherAddCityData("Воронеж", "25 С", "25 С"),
    WeatherAddCityData("Воронеж", "25 С", "25 С"),
    WeatherAddCityData("Воронеж", "25 С", "25 С"),
    WeatherAddCityData("Воронеж", "25 С", "25 С"),
    WeatherAddCityData("Воронеж", "25 С", "25 С"),
    WeatherAddCityData("Воронеж", "25 С", "25 С"),
    WeatherAddCityData("Воронеж", "25 С", "25 С"),
    WeatherAddCityData("Воронеж", "25 С", "25 С"),
    WeatherAddCityData("Воронеж", "25 С", "25 С"),
    WeatherAddCityData("Воронеж", "25 С", "25 С"),
    WeatherAddCityData("Воронеж", "25 С", "25 С"),
    WeatherAddCityData("Липецк", "25 С", "25 С")
)