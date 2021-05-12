package com.iamshekhargh.mypizzaapp.ui.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.iamshekhargh.mypizzaapp.R
import com.iamshekhargh.mypizzaapp.databinding.FragmentMenuBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class FragmentMenu : Fragment(R.layout.fragment_menu) {

    val viewModel: FragmentMenuViewModel by viewModels()
    lateinit var binding: FragmentMenuBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMenuBinding.bind(view)
        binding.apply {
            viewModel.tabList.forEach { label ->
                menuTablayout.addTab(
                    menuTablayout.newTab().setText(label)
                )
            }

            menuTempText.setOnClickListener {
                viewModel.openNext()
            }
        }

        setupEvents()
    }

    private fun setupEvents() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.eventFlow.collect { event ->
                when (event) {
                    is FragmentMenuEvents.ShowDishOverview -> {
                        val action =
                            FragmentMenuDirections.actionFragmentMenuToFragmentDishOverview()
                        findNavController().navigate(action)
                    }
                }
            }
        }
    }
}