package com.iamshekhargh.mypizzaapp.ui.dish

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.iamshekhargh.mypizzaapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentDishOverview : Fragment(R.layout.fragment_dish_overview) {

    val viewModel: FragmentDishOverviewViewModel by viewModels()
}