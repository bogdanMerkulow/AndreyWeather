package com.example.weatherproject.mainweather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherproject.databinding.FragmentMainWeatherBinding
import com.example.weatherproject.mainweather.item.WeatherItem
import com.example.weatherproject.mainweather.item.WeatherOverTimeItem
import com.example.weatherproject.mainweather.model.WeatherData
import com.example.weatherproject.mainweather.model.WeatherOverTimeData
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil


class FragmentMainWeather : Fragment() {

    private var _binding: FragmentMainWeatherBinding? = null
    private val binding get() = _binding!!

    private val weatherItemAdapter = ItemAdapter<WeatherItem>()
    private val fastAdapter = GenericFastAdapter.with(listOf(weatherItemAdapter))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMainWeatherBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.recyclerViewWeather) {
            adapter = fastAdapter
            itemAnimator = null
        }
        FastAdapterDiffUtil[weatherItemAdapter] = testWeatherData
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private val testWeatherData = listOf(
    WeatherItem(WeatherData("item 1")),
    WeatherItem(WeatherData("item 2")),
    WeatherItem(WeatherData("item 3")),
    WeatherItem(WeatherData("item 4")),
    WeatherItem(WeatherData("item 5")),
    WeatherItem(WeatherData("item 6")),
    WeatherItem(WeatherData("item 7")),
    WeatherItem(WeatherData("item 8")),
    WeatherItem(WeatherData("item 9"))
)