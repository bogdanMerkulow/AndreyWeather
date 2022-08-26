package com.example.weatherproject.mainweather.changecity.item

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.weatherproject.R
import com.example.weatherproject.addcity.dialogaddcity.model.DialogAddCityData
import com.example.weatherproject.databinding.RecyclerItemAddCityDialogBinding
import com.example.weatherproject.databinding.RecyclerItemDialogWeatherChangeCityBinding
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class DialogWeatherChangeCityItem(private val dialogAddCityData: DialogAddCityData) :
    AbstractBindingItem<RecyclerItemDialogWeatherChangeCityBinding>() {

    override fun bindView(binding: RecyclerItemDialogWeatherChangeCityBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)
        binding.changeCityDialog.text = dialogAddCityData.nameCity
    }

    override fun createBinding(
        inflater: LayoutInflater, parent: ViewGroup?
    ): RecyclerItemDialogWeatherChangeCityBinding =
        RecyclerItemDialogWeatherChangeCityBinding
            .inflate(inflater, parent, false)

    override val type: Int = R.id.background_item_add_city_dialog
}