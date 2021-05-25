package com.iamshekhargh.mypizzaapp.ui.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.iamshekhargh.mypizzaapp.R
import com.iamshekhargh.mypizzaapp.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class FragmentLogin : Fragment(R.layout.fragment_login) {

    val viewModel: FragmentLoginViewModel by viewModels()
    lateinit var binding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        binding.apply {

            loginFragmentSubmit.setOnClickListener {
                viewModel.submitButtonClicked(loginFragmentPhoneNumber.text.toString())
            }

            loginFragmentSkipLogin.setOnClickListener {
                viewModel.loginSkipped()
            }
        }

        setupEvents()
    }

    private fun setupEvents() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {

            viewModel.eventFlow.collect { event ->
                when (event) {
                    FragmentLoginEvents.LoadDashboard -> {
                        val directions =
                            FragmentLoginDirections.actionFragmentLoginToFragmentDashboard()
                        findNavController().navigate(directions)
                    }
                }
            }
        }
    }
}