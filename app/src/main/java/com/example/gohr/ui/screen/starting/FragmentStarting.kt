package com.example.gohr.ui.screen.starting

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.gohr.R
import com.example.gohr.databinding.ScreenStartingBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 26/07/2022.
 */
@AndroidEntryPoint
class FragmentStarting : Fragment(R.layout.screen_starting) {
    private val binding: ScreenStartingBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnOpenId.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentStarting_to_fragmentUserId)
        }
    }
}