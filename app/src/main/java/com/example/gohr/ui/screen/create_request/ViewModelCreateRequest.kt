package com.example.gohr.ui.screen.create_request

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 27/07/2022.
 */
@HiltViewModel
class ViewModelCreateRequest @Inject constructor() : ViewModel() {
    private var _selected = MutableStateFlow(1)
    var selected = _selected.asStateFlow()

    fun setSelected(value: Int) {
        if (selected.value != value) {
            _selected.value =value
        }
    }
}