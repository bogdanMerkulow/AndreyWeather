package com.example.weatherproject.common.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.weatherproject.R

fun AppCompatActivity.navigateToFragmentActivity(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.container, fragment)
        .commit()
}