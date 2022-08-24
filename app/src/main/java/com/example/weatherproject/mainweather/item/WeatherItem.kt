package com.example.weatherproject.mainweather.item

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.weatherproject.R
import com.example.weatherproject.databinding.RecyclerItemWeatherBinding
import com.example.weatherproject.mainweather.model.WeatherData
import com.example.weatherproject.mainweather.model.WeatherOverTimeData
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil

class WeatherItem(private val weatherData: WeatherData) :
    AbstractBindingItem<RecyclerItemWeatherBinding>() {

    private val weatherOverTimeItemAdapter = ItemAdapter<WeatherOverTimeItem>()
    private val fastAdapter = GenericFastAdapter.with(listOf(weatherOverTimeItemAdapter))

    override fun bindView(binding: RecyclerItemWeatherBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        with(binding.recyclerViewTimes) {
            adapter = fastAdapter
            itemAnimator = null
        }
        FastAdapterDiffUtil[weatherOverTimeItemAdapter] = testWeatherOverTimeData
    }

    override fun createBinding(
        inflater: LayoutInflater, parent: ViewGroup?
    ): RecyclerItemWeatherBinding =
        RecyclerItemWeatherBinding.inflate(inflater, parent, false)


    override val type: Int = R.id.background_item_main_weather
}

private val testWeatherOverTimeData = listOf(
    WeatherOverTimeItem(WeatherOverTimeData("12:00", "25 C")),
    WeatherOverTimeItem(WeatherOverTimeData("14:00", "25 C")),
    WeatherOverTimeItem(WeatherOverTimeData("16:00", "25 C")),
    WeatherOverTimeItem(WeatherOverTimeData("18:00", "25 C")),
    WeatherOverTimeItem(WeatherOverTimeData("20:00", "25 C")),
    WeatherOverTimeItem(WeatherOverTimeData("22:00", "25 C")),
    WeatherOverTimeItem(WeatherOverTimeData("00:00", "25 C"))
)