package com.example.weatherproject.mainweather

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
val dateFormat = SimpleDateFormat("dd")

@SuppressLint("SimpleDateFormat")
val dataFormatHours = SimpleDateFormat("H:mm ")

val dateFormatPreview = SimpleDateFormat("Сегодня, d MMM EEE", Locale("ru"))
val dateFormatDays = SimpleDateFormat("d MMM EEE", Locale("ru"))

fun Long.dateFormat(): String {
    return dateFormat.format(this * 1000)
}

fun Long.dateFormatDays(): String {
    return dateFormatDays.format(this)
}

fun Long.dateFormatPreview(): String {
    return dateFormatPreview.format(this)
}

fun Long.dateFormatHours(): String {
    return dataFormatHours.format(this)
}
