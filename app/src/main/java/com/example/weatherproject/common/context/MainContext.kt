package com.example.weatherproject.common.context

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.weatherproject.common.application.AppComponent
import com.example.weatherproject.common.application.MainApp

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> this.applicationContext.appComponent
    }

fun Fragment.toast(message: CharSequence) =
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()