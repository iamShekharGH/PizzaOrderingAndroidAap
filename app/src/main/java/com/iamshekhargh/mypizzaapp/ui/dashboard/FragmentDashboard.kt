package com.iamshekhargh.mypizzaapp.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.iamshekhargh.mypizzaapp.R
import com.iamshekhargh.mypizzaapp.databinding.FragmentDashboardBinding
import com.iamshekhargh.mypizzaapp.ui.dashboard.adapters.MainMenuAdapter
import com.iamshekhargh.mypizzaapp.ui.dashboard.adapters.PromotionalOffersAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class FragmentDashboard : Fragment(R.layout.fragment_dashboard) {
    val viewModel: FragmentDashboardViewModel by viewModels()
    lateinit var binding: FragmentDashboardBinding

    lateinit var promotionalOffersAdapter: PromotionalOffersAdapter
    lateinit var dashboardMainMenuAdapter: MainMenuAdapter
    lateinit var offersAdapter: PromotionalOffersAdapter
    lateinit var bestsellerAdapter: PromotionalOffersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //request This information at the beginning
        viewModel.requestDashboardInformation()

        promotionalOffersAdapter = PromotionalOffersAdapter()
        dashboardMainMenuAdapter = MainMenuAdapter()

        offersAdapter = PromotionalOffersAdapter()
        bestsellerAdapter = PromotionalOffersAdapter()

        binding = FragmentDashboardBinding.bind(view)
        binding.apply {
            dashboardRadioDelivery.isChecked = true
            dashboardRadioDineIn.setOnClickListener {
                viewModel.dineInRadioClicked()
            }
            dashboardRadioTakeaway.setOnClickListener {
                viewModel.takeawayRadioClicked()
            }

            dashboardPromotionOffers.adapter = promotionalOffersAdapter
            dashboardRvMainMenu.adapter = dashboardMainMenuAdapter
            dashboardRvOffers.adapter = offersAdapter
            dashboardRvBestsellers.adapter = bestsellerAdapter
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