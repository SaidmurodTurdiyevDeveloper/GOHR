package com.example.gohr.ui.screen.user_id

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.gohr.R
import com.example.gohr.databinding.ScreenUserIdBinding
import com.example.gohr.other.Constants
import com.example.gohr.other.extention.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 26/07/2022.
 */
@AndroidEntryPoint
class FragmentUserId : Fragment(R.layout.screen_user_id) {
    private val binding: ScreenUserIdBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadUI()
    }

    private fun loadUI() {
        binding.btnOne.setOnClickListener {
            val text = binding.tvId.text.toString().trim()
            binding.tvId.text = text + "1"
            checkText(text)
        }
        binding.btnTwo.setOnClickListener {
            val text = binding.tvId.text.toString().trim()
            binding.tvId.text = text + "2"
            checkText(text)
        }
        binding.btnThree.setOnClickListener {
            val text = binding.tvId.text.toString().trim()
            binding.tvId.text = text + "3"
            checkText(text)
        }
        binding.btnFour.setOnClickListener {
            val text = binding.tvId.text.toString().trim()
            binding.tvId.text = text + "4"
            checkText(text)
        }
        binding.btnFive.setOnClickListener {
            val text = binding.tvId.text.toString().trim()
            binding.tvId.text = text + "5"
            checkText(text)
        }
        binding.btnSix.setOnClickListener {
            val text = binding.tvId.text.toString().trim()
            binding.tvId.text = text + "6"
            checkText(text)
        }
        binding.btnSeven.setOnClickListener {
            val text = binding.tvId.text.toString().trim()
            binding.tvId.text = text + "7"
            checkText(text)
        }
        binding.btnEight.setOnClickListener {
            val text = binding.tvId.text.toString().trim()
            binding.tvId.text = text + "8"
            checkText(text)
        }
        binding.btnNine.setOnClickListener {
            val text = binding.tvId.text.toString().trim()
            binding.tvId.text = text + "9"
            checkText(text)
        }
        binding.btnZero.setOnClickListener {
            val text = binding.tvId.text.toString().trim()
            binding.tvId.text = text + "0"
            checkText(text)
        }
        binding.btnRemove.setOnClickListener {
            val text = binding.tvId.text.toString().trim()
            if (text.isNotEmpty()) {
                binding.tvId.text = text.substring(0, text.length - 1)
            }
            checkText(text)
        }
        binding.btnRemove.setOnLongClickListener {
            removeFast()
            true
        }
        binding.btnBlock.setOnClickListener {
            val userId = binding.tvId.text.toString().trim()
            findNavController().navigate(R.id.action_fragmentUserId_to_fragmentPassword, bundleOf(Constants.MOVE_ID to userId))
        }
        binding.btnOpenQr.setOnClickListener {
            showToast("Bu joy endi qilinadi")
        }
    }

    private fun checkText(text: String) {
        if (text.length > 18) binding.tvId.textSize = 12f
        else binding.tvId.textSize = 32f
    }

    private fun removeFast() {
        lifecycleScope.launch {
            while (binding.btnRemove.isPressed) {
                val text = binding.tvId.text.toString().trim()
                if (text.isNotEmpty()) {
                    binding.tvId.text = text.substring(0, text.length - 1)
                }
                checkText(text)
                delay(100)
            }
        }
    }
}