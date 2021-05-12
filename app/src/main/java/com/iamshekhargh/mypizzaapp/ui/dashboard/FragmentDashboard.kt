package com.iamshekhargh.mypizzaapp.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.iamshekhargh.mypizzaapp.R
import com.iamshekhargh.mypizzaapp.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class FragmentDashboard : Fragment(R.layout.fragment_dashboard) {
    val viewModel: FragmentDashboardViewModel by viewModels()
    lateinit var binding: FragmentDashboardBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDashboardBinding.bind(view)
        binding.apply {
            dashboardRadioDelivery.isChecked = true
            dashboardRadioDineIn.setOnClickListener {
                viewModel.dineInRadioClicked()
            }
            dashboardRadioTakeaway.setOnClickListener {
                viewModel.takeawayRadioClicked()
            }
        }

        setupEvents()
    }

    private fun setupEvents() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.eventFlow.collect { event ->
                when (event) {
                    is FragmentDashboardEvents.OpenMenu -> {
                        val action =
                            FragmentDashboardDirections.actionFragmentDashboardToFragmentMenu()
                        findNavController().navigate(action)
                    }
                }
            }
        }
    }
}