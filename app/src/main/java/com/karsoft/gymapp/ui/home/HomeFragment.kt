package com.karsoft.gymapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.karsoft.gymapp.R
import com.karsoft.gymapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initListeners()


    }

    private fun initListeners() {
        binding.cardCategory.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToCategoryFragment()
            )
        }

        binding.cardBrand.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToBrandFragment()
            )
        }

        binding.cardTransaction.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToTransactionFragment()
            )
        }

        binding.cardStok.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToStokFragment()
            )
        }
    }
}