package com.example.weatherproject.mainweather.item

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.weatherproject.R
import com.example.weatherproject.databinding.RecyclerItemWeatherBinding
import com.example.weatherproject.mainweather.model.WeatherDataApi
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil

class WeatherItem(
    private val weatherData: WeatherDataApi
) : AbstractBindingItem<RecyclerItemWeatherBinding>() {

    private val weatherOverTimeItemAdapter = ItemAdapter<WeatherOverTimeItem>()
    private val fastAdapter = GenericFastAdapter.with(listOf(weatherOverTimeItemAdapter))

    override fun bindView(binding: RecyclerItemWeatherBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        with(binding) {
            textDays.text = weatherData.pressure.toString()
            textDaysWeek.text = weatherData.pressure.toString()
            textDaysTemp1.text = weatherData.temp_min.toString()
            textDaysTemp2.text = weatherData.temp_max.toString()
        }
        with(binding.recyclerViewTimes) {
            adapter = fastAdapter
            itemAnimator = null
        }
        FastAdapterDiffUtil[weatherOverTimeItemAdapter] =
            weatherData.list.map { WeatherOverTimeItem(it) }
    }

    override fun createBinding(
        inflater: LayoutInflater, parent: ViewGroup?
    ): RecyclerItemWeatherBinding =
        RecyclerItemWeatherBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.background_item_main_weather
}