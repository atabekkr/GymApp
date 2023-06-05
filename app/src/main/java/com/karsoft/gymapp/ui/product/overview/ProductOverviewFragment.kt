package com.karsoft.gymapp.ui.product.overview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.karsoft.gymapp.R
import com.karsoft.gymapp.databinding.FragmentProductOverviewBinding

class ProductOverviewFragment : Fragment(R.layout.fragment_product_overview) {

    private lateinit var binding: FragmentProductOverviewBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductOverviewBinding.bind(view)

        binding.expandableCharacteristic.setOnClickListener {
            if (binding.tvDesc.visibility == View.VISIBLE) {
                binding.tvDesc.visibility = View.GONE
            } else {
                binding.tvDesc.visibility = View.VISIBLE
            }
        }
    }
}