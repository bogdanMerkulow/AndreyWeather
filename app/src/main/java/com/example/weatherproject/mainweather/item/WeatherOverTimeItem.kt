package com.example.weatherproject.mainweather.item

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.weatherproject.R
import com.example.weatherproject.databinding.RecyclerItemWeatherTimeOverBinding
import com.example.weatherproject.mainweather.TIME_FORMAT
import com.example.weatherproject.mainweather.dateFormatHours
import com.example.weatherproject.mainweather.imageWeather
import com.example.weatherproject.mainweather.model.WeatherOverTimeData
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class WeatherOverTimeItem(private val weatherOverTimeData: WeatherOverTimeData) :
    AbstractBindingItem<RecyclerItemWeatherTimeOverBinding>() {


    @SuppressLint("SetTextI18n")
    override fun bindView(binding: RecyclerItemWeatherTimeOverBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        val dtTimes = weatherOverTimeData.dt.times(TIME_FORMAT)

        Glide
            .with(binding.root)
            .load(weatherOverTimeData.icon.imageWeather())
            .into(binding.imageClock)

        binding.textClock.text = dtTimes.dateFormatHours()
        binding.textClockTemp.text = "${weatherOverTimeData.temp.toInt()}°"

    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): RecyclerItemWeatherTimeOverBinding =
        RecyclerItemWeatherTimeOverBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.background_main_weather_time_over
}