package com.iamshekhargh.mypizzaapp.ui.language

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.iamshekhargh.mypizzaapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentChooseLanguage : Fragment(R.layout.fragment_choose_language) {

    val viewModel: FragmentChooseLanguageViewModel by viewModels()
}