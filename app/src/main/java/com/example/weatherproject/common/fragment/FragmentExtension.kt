package com.example.weatherproject.common.fragment

import androidx.fragment.app.Fragment
import com.example.weatherproject.R
import com.example.weatherproject.common.context.appComponent

fun Fragment.navigateToFragment(fragment: Fragment) {
    this.parentFragmentManager
        .beginTransaction()
        .replace(R.id.container, fragment, fragment.javaClass.simpleName)
        .addToBackStack(fragment.javaClass.simpleName)
        .commit()
}

fun Fragment.getViewModelFactory() =
    requireContext().applicationContext.appComponent.getViewModelFactory()