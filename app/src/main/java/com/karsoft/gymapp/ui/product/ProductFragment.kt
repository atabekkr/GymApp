package com.karsoft.gymapp.ui.product

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.karsoft.gymapp.MainActivity
import com.karsoft.gymapp.R
import com.karsoft.gymapp.data.product.ProductDao
import com.karsoft.gymapp.databinding.FragmentProductBinding
import com.karsoft.gymapp.data.product.ProductData
import com.karsoft.gymapp.data.room.GymDatabase
import com.karsoft.gymapp.ui.category.dialogcategory.AddCategoryDialog
import com.karsoft.gymapp.ui.product.adapter.ProductAdapter

class ProductFragment : Fragment(R.layout.fragment_product) {

    private lateinit var binding: FragmentProductBinding
    private val adapter = ProductAdapter()
    private lateinit var database: GymDatabase
    private lateinit var dao: ProductDao
    private lateinit var dialog: AddCategoryDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        initViews(view)
        initListeners()

    }

    private fun initData() {
        database = GymDatabase.getInstance(requireContext())
        dao = database.getProductDao()
    }

    private fun initListeners() {

        adapter.setOnDeleteClickListener {
            lifecycleScope.launchWhenResumed {
                dao.deleteProduct(it)
                adapter.submitList(dao.getAllProducts())
            }
        }

        binding.btnAdd.setOnClickListener {

            dialog = AddCategoryDialog()
            dialog.show(requireActivity().supportFragmentManager, dialog.tag)
            dialog.setOnAddSuccessListener {
                lifecycleScope.launchWhenResumed {
                    adapter.submitList(dao.getAllProducts())
                }
            }
        }
    }

    private fun initViews(view: View) {
        binding = FragmentProductBinding.bind(view)

        binding.recyclerView.adapter = adapter

        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        lifecycleScope.launchWhenResumed {
            adapter.submitList(dao.getAllProducts())
        }
    }
}