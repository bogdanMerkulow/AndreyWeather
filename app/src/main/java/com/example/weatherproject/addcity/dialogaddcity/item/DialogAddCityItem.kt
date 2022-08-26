package com.example.weatherproject.addcity.dialogaddcity.item

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.weatherproject.R
import com.example.weatherproject.addcity.dialogaddcity.model.DialogAddCityData
import com.example.weatherproject.databinding.RecyclerItemAddCityDialogBinding
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class DialogAddCityItem(private val dialogAddCityData: DialogAddCityData) :
    AbstractBindingItem<RecyclerItemAddCityDialogBinding>() {

    override fun bindView(binding: RecyclerItemAddCityDialogBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)
        binding.addCityDialog.text = dialogAddCityData.nameCity
    }

    override fun createBinding(
        inflater: LayoutInflater, parent: ViewGroup?
    ): RecyclerItemAddCityDialogBinding =
        RecyclerItemAddCityDialogBinding
            .inflate(inflater, parent, false)

    override val type: Int = R.id.background_item_add_city_dialog
}