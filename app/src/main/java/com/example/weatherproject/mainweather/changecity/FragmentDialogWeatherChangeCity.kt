package com.example.weatherproject.mainweather.changecity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.weatherproject.R
import com.example.weatherproject.addcity.dialogaddcity.item.DialogAddCityItem
import com.example.weatherproject.addcity.dialogaddcity.model.DialogAddCityData
import com.example.weatherproject.addcity.item.WeatherAddCityItem
import com.example.weatherproject.addcity.model.WeatherAddCityData
import com.example.weatherproject.databinding.FragmentDialogAddCityBinding
import com.example.weatherproject.databinding.FragmentDialogWeatherChangeCityBinding
import com.example.weatherproject.mainweather.changecity.item.DialogWeatherChangeCityItem
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil

class FragmentDialogWeatherChangeCity : DialogFragment() {

    private var _binding: FragmentDialogWeatherChangeCityBinding? = null
    private val binding get() = _binding!!

    private val dialogAddCityItemAdapter = ItemAdapter<DialogWeatherChangeCityItem>()
    private val fastAdapter = GenericFastAdapter.with(listOf(dialogAddCityItemAdapter))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentDialogWeatherChangeCityBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.recyclerViewChangeCityDialog) {
            adapter = fastAdapter
            itemAnimator = null
        }
        FastAdapterDiffUtil[dialogAddCityItemAdapter] = testDialogAddCityData
        binding.btnCancelChangeCityDialog.setOnClickListener {
            dismiss()
        }
    }
    override fun getTheme(): Int = R.style.RoundedCornersDialog

}

private val testDialogAddCityData = listOf(
    DialogWeatherChangeCityItem(DialogAddCityData("Москва")),
    DialogWeatherChangeCityItem(DialogAddCityData("Санкт-Петербург")),
    DialogWeatherChangeCityItem(DialogAddCityData("Тамбов")),
    DialogWeatherChangeCityItem(DialogAddCityData("Воронеж"))
)