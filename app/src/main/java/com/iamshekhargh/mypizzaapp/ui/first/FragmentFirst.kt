package com.iamshekhargh.mypizzaapp.ui.first

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.iamshekhargh.mypizzaapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentFirst : Fragment(R.layout.fragment_first) {

    val viewModel: FragmentFirstViewModel by viewModels()
}