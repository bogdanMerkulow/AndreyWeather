package com.example.weatherproject.mainweather.item

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.weatherproject.R
import com.example.weatherproject.databinding.RecyclerItemWeatherTimeOverBinding
import com.example.weatherproject.mainweather.dataFormatHours
import com.example.weatherproject.mainweather.imageWeather
import com.example.weatherproject.mainweather.model.WeatherOverTimeData
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class WeatherOverTimeItem(private val weatherOverTimeData: WeatherOverTimeData) :
    AbstractBindingItem<RecyclerItemWeatherTimeOverBinding>() {


    override fun bindView(binding: RecyclerItemWeatherTimeOverBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        val dtTimes = weatherOverTimeData.dt.times(1000)

        Glide
            .with(binding.root)
            .load(weatherOverTimeData.icon.imageWeather)
            .into(binding.imageClock)

        binding.textClock.text = dataFormatHours.format(dtTimes)
        binding.textClockTemp.text = "${weatherOverTimeData.temp.toInt()}°"

    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): RecyclerItemWeatherTimeOverBinding =
        RecyclerItemWeatherTimeOverBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.background_main_weather_time_over
}