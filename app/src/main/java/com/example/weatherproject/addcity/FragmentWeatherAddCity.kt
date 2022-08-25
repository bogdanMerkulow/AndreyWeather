package com.example.weatherproject.addcity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherproject.R
import com.example.weatherproject.addcity.item.WeatherAddCityItem
import com.example.weatherproject.addcity.model.WeatherAddCityData
import com.example.weatherproject.common.fragment.navigateToFragment
import com.example.weatherproject.databinding.FragmentWeatherAddCityBinding
import com.example.weatherproject.mainweather.FragmentMainWeather
import com.example.weatherproject.mainweather.item.WeatherItem
import com.example.weatherproject.mainweather.model.WeatherData
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil


class FragmentWeatherAddCity : Fragment() {

    private var _binding: FragmentWeatherAddCityBinding? = null
    private val binding get() = _binding!!

    private val weatherAddCityItemAdapter = ItemAdapter<WeatherAddCityItem>()
    private val fastAdapter = GenericFastAdapter.with(listOf(weatherAddCityItemAdapter))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentWeatherAddCityBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.recyclerViewAddCity) {
            adapter = fastAdapter
            itemAnimator = null
        }

        FastAdapterDiffUtil[weatherAddCityItemAdapter] = testWeatherAddCityData

        binding.btnBackAddCity.setOnClickListener {
            navigateToFragment(FragmentMainWeather())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private val testWeatherAddCityData = listOf(
    WeatherAddCityItem(WeatherAddCityData("Москва", "25 С", "25 С")),
    WeatherAddCityItem(WeatherAddCityData("Санкт-Петербург", "25 С", "25 С")),
    WeatherAddCityItem(WeatherAddCityData("Тамбов", "25 С", "25 С")),
    WeatherAddCityItem(WeatherAddCityData("Воронеж", "25 С", "25 С")),
    WeatherAddCityItem(WeatherAddCityData("Воронеж", "25 С", "25 С")),
    WeatherAddCityItem(WeatherAddCityData("Воронеж", "25 С", "25 С")),
    WeatherAddCityItem(WeatherAddCityData("Воронеж", "25 С", "25 С")),
    WeatherAddCityItem(WeatherAddCityData("Воронеж", "25 С", "25 С")),
    WeatherAddCityItem(WeatherAddCityData("Воронеж", "25 С", "25 С")),
    WeatherAddCityItem(WeatherAddCityData("Воронеж", "25 С", "25 С")),
    WeatherAddCityItem(WeatherAddCityData("Воронеж", "25 С", "25 С")),
    WeatherAddCityItem(WeatherAddCityData("Воронеж", "25 С", "25 С")),
    WeatherAddCityItem(WeatherAddCityData("Воронеж", "25 С", "25 С")),
    WeatherAddCityItem(WeatherAddCityData("Липецк", "25 С", "25 С"))

)


