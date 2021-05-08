package com.iamshekhargh.mypizzaapp.ui.login

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.iamshekhargh.mypizzaapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentLogin : Fragment(R.layout.fragment_login) {

    val viewModel: FragmentLoginViewModel by viewModels()
}