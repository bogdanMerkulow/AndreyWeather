package com.example.weatherproject.mainweather

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
val dateFormat = SimpleDateFormat("dd")

@SuppressLint("SimpleDateFormat")
val dataFormatHours = SimpleDateFormat("H:mm ")

val dateFormatPreview = SimpleDateFormat("Сегодня, d MMM EEE", Locale("ru"))
val dateFormatDays = SimpleDateFormat("d MMM EEE", Locale("ru"))


fun Context?.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
