package com.example.weatherproject.mainweather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.weatherproject.R
import com.example.weatherproject.common.fragment.getViewModelFactory
import com.example.weatherproject.common.navigation.navigate
import com.example.weatherproject.databinding.FragmentMainWeatherBinding
import com.example.weatherproject.mainweather.item.WeatherItem
import com.example.weatherproject.mainweather.model.State
import com.example.weatherproject.mainweather.model.WeatherData
import com.example.weatherproject.mainweather.model.WeatherPreviewData
import com.example.weatherproject.mainweather.viewmodel.MainWeatherViewModel
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil


class FragmentMainWeather : Fragment() {

    private var _binding: FragmentMainWeatherBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainWeatherViewModel by viewModels { getViewModelFactory() }

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
        setupObservables()
        setupListeners()
        viewModel.loadWeather()

    }

    private fun setupObservables() {
        with(viewModel) {
            weatherWeek.observe(viewLifecycleOwner, ::onDataLoaded)
            weatherPreview.observe(viewLifecycleOwner, ::onDataLoadedPreview)
            screenState.observe(viewLifecycleOwner, ::stateScreen)
        }
    }

    private fun onDataLoaded(weatherData: List<WeatherData>) {
        FastAdapterDiffUtil[weatherItemAdapter] = weatherData.map { WeatherItem(it) }
    }

    private fun onDataLoadedPreview(weatherPreviewData: WeatherPreviewData) {
        val dtTimes = weatherPreviewData.dt.times(TIME_FORMAT)
        binding.apply {
            textPreviewWeather.text = dtTimes.dateFormatPreview()
            textFeelingTempPreview.text = weatherPreviewData.description
            textTempPreview.text = requireContext().resources.getString(
                R.string.temp, weatherPreviewData.temp.toInt().toString()
            )
        }
        Glide
            .with(requireView())
            .load(weatherPreviewData.icon.imageWeather())
            .into(binding.imageWeatherPreview)
    }

    private fun setupListeners() {
        binding.btnGeolocation.setOnClickListener {
            navigate(R.id.main_weather_to_weather_add_city)
        }
        binding.btnSearch.setOnClickListener {
            navigate(R.id.main_weather_to_dialog_change_city)
        }
    }

    private fun stateScreen(state: State) {
        when (state) {
            State.Loading -> onScreenLoading()
            State.Loaded -> onScreenLoaded()
            State.Error -> onScreenError()
        }
    }

    private fun onScreenLoading() {
//        binding.group.isVisible = false
        binding.includedStatusLayout.groupError.isVisible = false
        binding.includedStatusLayout.progressBarState.isVisible = true

    }

    private fun onScreenLoaded() {
        binding.group.isVisible = true
        binding.includedStatusLayout.groupError.isVisible = false
        binding.includedStatusLayout.progressBarState.isVisible = false

    }

    private fun onScreenError() {
        binding.group.isVisible = false
        binding.includedStatusLayout.progressBarState.isVisible = false
        binding.includedStatusLayout.groupError.isVisible = true

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

