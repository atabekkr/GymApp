package com.karsoft.gymapp.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.karsoft.gymapp.R
import com.karsoft.gymapp.data.constants.Constants
import com.karsoft.gymapp.data.constants.UserData
import com.karsoft.gymapp.data.local.LocalStorage
import com.karsoft.gymapp.databinding.FragmentAuthBinding

class AuthFragment : Fragment(R.layout.fragment_auth) {

    private val binding by viewBinding(FragmentAuthBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {

        binding.btnLogin.setOnClickListener {
            val id = binding.tietLogin.text.toString()
            val password = binding.tietPassword.text.toString()
            if (id.isNotEmpty() && password.isNotEmpty()) {
                val data = UserData(id, password)
                if (login(data)) {
                    LocalStorage().isLogin = true
                    findNavController().navigate(
                        AuthFragmentDirections.actionAuthFragmentToContainerFragment()
                    )
                } else {
                    Toast.makeText(requireContext(), "логин или пароль неправильно", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun login(data: UserData): Boolean {
        Constants.users().forEach {
            if (it == data) return true
        }
        return false
    }
}