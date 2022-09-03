package com.example.weatherproject.mainweather.item

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.weatherproject.R
import com.example.weatherproject.databinding.RecyclerItemWeatherBinding
import com.example.weatherproject.mainweather.model.WeatherData
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil

class WeatherItem(
    private val weatherData: WeatherData
) : AbstractBindingItem<RecyclerItemWeatherBinding>() {

    private val weatherOverTimeItemAdapter = ItemAdapter<WeatherOverTimeItem>()
    private val fastAdapter = GenericFastAdapter.with(listOf(weatherOverTimeItemAdapter))

    override fun bindView(binding: RecyclerItemWeatherBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        with(binding) {
            textDays.text = weatherData.dt_txt
            textDaysWeek.text = weatherData.dt_txt
            textDaysTemp1.text = weatherData.temp_min
            textDaysTemp2.text = weatherData.temp_max
        }
        with(binding.recyclerViewTimes) {
            adapter = fastAdapter
            itemAnimator = null
        }
//        FastAdapterDiffUtil[weatherOverTimeItemAdapter] = weatherData.dt_txt

        FastAdapterDiffUtil[weatherOverTimeItemAdapter] =
            weatherData.list.map { WeatherOverTimeItem(it) }

    }

    override fun createBinding(
        inflater: LayoutInflater, parent: ViewGroup?
    ): RecyclerItemWeatherBinding =
        RecyclerItemWeatherBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.background_item_main_weather
}