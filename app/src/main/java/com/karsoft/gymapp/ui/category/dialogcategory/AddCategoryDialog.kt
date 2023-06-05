package com.karsoft.gymapp.ui.category.dialogcategory
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.karsoft.gymapp.R
import com.karsoft.gymapp.data.product.ProductDao
import com.karsoft.gymapp.data.product.ProductData
import com.karsoft.gymapp.data.room.GymDatabase
import com.karsoft.gymapp.databinding.DialogAddCategoryBinding
import kotlinx.coroutines.launch


class AddCategoryDialog : DialogFragment(R.layout.dialog_add_category) {

    private lateinit var binding: DialogAddCategoryBinding
    private lateinit var dao: ProductDao
    private lateinit var database: GymDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DialogAddCategoryBinding.bind(view)

        database = GymDatabase.getInstance(requireContext())
        dao = database.getProductDao()

        binding.btnAdd.setOnClickListener {
            val name = binding.etCategory.text.toString()

            if (name.isNotEmpty()) {
                val product = ProductData(
                    name = name
                )
                lifecycleScope.launch {
                    dao.addProduct(product)
                    Log.d("nuee", "ksjfkdsjfk")
                    onAddSuccess.invoke()
                    dismiss()
                }
            } else {
                Toast.makeText(requireContext(), "Toltir", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private var onAddSuccess: () -> Unit = {}
    fun setOnAddSuccessListener(onAddSuccess: () -> Unit) {
        this.onAddSuccess = onAddSuccess
    }

}