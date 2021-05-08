package com.iamshekhargh.mypizzaapp.ui.menu

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.iamshekhargh.mypizzaapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentMenu : Fragment(R.layout.fragment_menu) {

    val viewModel: FragmentMenuViewModel by viewModels()
}