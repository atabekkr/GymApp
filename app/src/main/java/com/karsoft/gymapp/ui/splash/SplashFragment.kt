package com.karsoft.gymapp.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.karsoft.gymapp.R
import com.karsoft.gymapp.data.local.LocalStorage
import kotlinx.coroutines.delay

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenResumed {
            delay(1000)
            if (LocalStorage().isLogin) {
                findNavController().navigate(
                    SplashFragmentDirections.actionSplashFragmentToContainerFragment()
                )
            } else {
                findNavController().navigate(
                    SplashFragmentDirections.actionSplashFragmentToAuthFragment()
                )
            }
        }
    }
}