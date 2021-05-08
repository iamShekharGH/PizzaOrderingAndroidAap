package com.iamshekhargh.mypizzaapp.ui.dashboard


import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.iamshekhargh.mypizzaapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentDashboard : Fragment(R.layout.fragment_dashboard) {
    val viewModel: FragmentDashboardViewModel by viewModels()
}