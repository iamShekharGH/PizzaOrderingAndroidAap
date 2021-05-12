package com.iamshekhargh.mypizzaapp.ui.dish

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.iamshekhargh.mypizzaapp.R
import com.iamshekhargh.mypizzaapp.databinding.FragmentDishOverviewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentDishOverview : Fragment(R.layout.fragment_dish_overview) {

    val viewModel: FragmentDishOverviewViewModel by viewModels()
    lateinit var binding: FragmentDishOverviewBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDishOverviewBinding.bind(view)

        binding.apply {

        }

    }
}