package com.example.gohr.ui.screen.create_request

import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.gohr.R
import com.example.gohr.databinding.ScreenCreateRequestBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 27/07/2022.
 */
@AndroidEntryPoint
class FragmentCreateRequest : Fragment(R.layout.screen_create_request) {
    private val binding: ScreenCreateRequestBinding by viewBinding()
    private var selectList = emptyArray<Drawable?>()
    private var unselect = emptyArray<Drawable?>()
    private val viewModel: ViewModelCreateRequest by viewModels()
    private var selected = -1
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        selectList = arrayOf(requireContext().getDrawable(R.drawable.tab_layout_bg), requireContext().getDrawable(R.drawable.tab_layout_fg))
        unselect = arrayOf(requireContext().getDrawable(R.drawable.tab_layout_fg), requireContext().getDrawable(R.drawable.tab_layout_bg))

        binding.item1.setOnClickListener {
            viewModel.setSelected(1)
        }
        binding.item2.setOnClickListener {
            viewModel.setSelected(2)
        }
        binding.item3.setOnClickListener {
            viewModel.setSelected(3)
        }
        loadUI()
    }

    private fun select(selectItem: Int, isSelect: Boolean = false) {
        val mTransition = if (isSelect) TransitionDrawable(selectList) else TransitionDrawable(unselect)
        val item = if (selectItem == 1) binding.item1 else if (selectItem == 2) binding.item2 else if (selectItem == 3) binding.item3 else null
        item?.background = mTransition
        if (isSelect) {
            binding.permissionOne.isVisible = selectItem == 1
            binding.permissionTwo.isVisible = selectItem == 1
            binding.advanceOne.isVisible = selectItem == 2
            binding.advanceTwo.isVisible = selectItem == 2
            binding.holidayOne.isVisible = selectItem == 3
        }
        mTransition.startTransition(500)
    }

    private fun loadUI() {
        lifecycleScope.launchWhenStarted {
            viewModel.selected.collectLatest {
                if (selected != 1)
                    binding.item1.setBackgroundResource(R.drawable.tab_layout_bg)
                if (selected != 2)
                    binding.item2.setBackgroundResource(R.drawable.tab_layout_bg)
                if (selected != 3)
                    binding.item3.setBackgroundResource(R.drawable.tab_layout_bg)
                if (selected > 0)
                    select(selected, false)
                select(it, true)
                selected = it
            }
        }
    }
    private fun showSubtitle() {

    }
}