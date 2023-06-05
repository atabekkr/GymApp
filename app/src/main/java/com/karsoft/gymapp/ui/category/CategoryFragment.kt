package com.karsoft.gymapp.ui.category

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.karsoft.gymapp.R
import com.karsoft.gymapp.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment(R.layout.fragment_category) {

    private val binding by viewBinding(FragmentCategoryBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initListeners()


    }

    private fun initListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(
                CategoryFragmentDirections.actionCategoryFragmentToAddCategoryDialog()
            )
        }

        binding.cardMobile.setOnClickListener {
            findNavController().navigate(
                CategoryFragmentDirections.actionCategoryFragmentToProductFragment()
            )
        }

        binding.cardClothes.setOnClickListener {
            findNavController().navigate(
                CategoryFragmentDirections.actionCategoryFragmentToClothesFragment2()
            )
        }

        binding.cardTovar.setOnClickListener {
            findNavController().navigate(
                CategoryFragmentDirections.actionCategoryFragmentToTovarFragment()
            )
        }

        binding.cardTren.setOnClickListener {
            findNavController().navigate(
                CategoryFragmentDirections.actionCategoryFragmentToTrenFragment()
            )
        }

        binding.cardShaker.setOnClickListener {
            findNavController().navigate(
                CategoryFragmentDirections.actionCategoryFragmentToShakerFragment()
            )
        }

        binding.cardBackPack.setOnClickListener {
            findNavController().navigate(
                CategoryFragmentDirections.actionCategoryFragmentToBackPackFragment()
            )
        }
    }
}