package com.example.gohr.ui.screen.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.gohr.R
import com.example.gohr.databinding.ScreenHomeBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 26/07/2022.
 */
@AndroidEntryPoint
class FragmentHome : Fragment(R.layout.screen_home) {
    private val binding: ScreenHomeBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.fbAdd.setOnClickListener {
            findNavController().navigate(R.id.action_requset_to_fragmentCreateRequest)
        }
    }
}