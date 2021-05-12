package com.iamshekhargh.mypizzaapp.ui.first

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.iamshekhargh.mypizzaapp.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class FragmentFirst : Fragment(R.layout.fragment_first) {

    val viewModel: FragmentFirstViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.downloadResources()


        setupEvents()
    }

    private fun setupEvents() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.eventsFlow.collect { event ->
                when (event) {
                    FirstFragmentEvents.OpenLoginFragment -> {
                        val action =
                            FragmentFirstDirections.actionFragmentFirstToFragmentChooseLanguage()
                        findNavController().navigate(action)
                    }
                }

            }
        }
    }
}