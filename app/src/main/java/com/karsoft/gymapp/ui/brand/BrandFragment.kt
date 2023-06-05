package com.karsoft.gymapp.ui.brand

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.karsoft.gymapp.R
import com.karsoft.gymapp.data.brand.BrandData
import com.karsoft.gymapp.databinding.FragmentBrandBinding
import com.karsoft.gymapp.ui.brand.adapter.BrandAdapter

class BrandFragment : Fragment(R.layout.fragment_brand) {

    private lateinit var binding: FragmentBrandBinding
    private val adapter = BrandAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBrandBinding.bind(view)

        initViews()
        initListeners()

        val list = mutableListOf<BrandData>()
        list.add(BrandData("Whey", 0))
        list.add(BrandData("MyProtein", 0))
        list.add(BrandData("PowerPro", 0))
        list.add(BrandData("OstroVit", 0))
        list.add(BrandData("BioTech", 0))
        list.add(BrandData("Optimum nutrition", 0))
        list.add(BrandData("BSN", 0))
        list.add(BrandData("BioTech USA", 0))
        list.add(BrandData("Scites Nutrition", 0))

        adapter.submitList(list)
    }

    private fun initListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(
                BrandFragmentDirections.actionBrandFragmentToAddCategoryDialog()
            )
        }
    }

    private fun initViews() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }
}