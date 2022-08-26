package com.example.weatherproject.addcity.dialogaddcity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.weatherproject.R
import com.example.weatherproject.addcity.dialogaddcity.item.DialogAddCityItem
import com.example.weatherproject.addcity.dialogaddcity.model.DialogAddCityData
import com.example.weatherproject.databinding.FragmentDialogAddCityBinding
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil

class FragmentDialogAddCity : DialogFragment() {

    private var _binding: FragmentDialogAddCityBinding? = null
    private val binding get() = _binding!!

    private val dialogAddCityItemAdapter = ItemAdapter<DialogAddCityItem>()
    private val fastAdapter = GenericFastAdapter.with(listOf(dialogAddCityItemAdapter))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentDialogAddCityBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.recyclerViewAddCityDialog) {
            adapter = fastAdapter
            itemAnimator = null
        }
        FastAdapterDiffUtil[dialogAddCityItemAdapter] = testDialogAddCityData
        binding.btnCancelAddCityDialog.setOnClickListener {
            dismiss()
        }
    }

    override fun getTheme(): Int = R.style.RoundedCornersDialog
}

private val testDialogAddCityData = listOf(
    DialogAddCityItem(DialogAddCityData("Москва")),
    DialogAddCityItem(DialogAddCityData("Санкт-Петербург")),
    DialogAddCityItem(DialogAddCityData("Тамбов")),
    DialogAddCityItem(DialogAddCityData("Воронеж"))
)