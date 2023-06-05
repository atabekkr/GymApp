package com.karsoft.gymapp.ui.stok

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.room.util.findColumnIndexBySuffix
import com.karsoft.gymapp.R
import com.karsoft.gymapp.databinding.FragmentStokBinding

class StokFragment : Fragment(R.layout.fragment_stok) {

    private lateinit var binding: FragmentStokBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStokBinding.bind(view)

        binding.category.setOnClickListener {
            findNavController().navigate(
                StokFragmentDirections.actionStokFragmentToCategoryFragment()
            )
        }
    }
}