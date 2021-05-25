package com.iamshekhargh.mypizzaapp.ui.language

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.iamshekhargh.mypizzaapp.R
import com.iamshekhargh.mypizzaapp.databinding.FragmentChooseLanguageBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import java.util.*

@AndroidEntryPoint
class FragmentChooseLanguage : Fragment(R.layout.fragment_choose_language) {

    val viewModel: FragmentChooseLanguageViewModel by viewModels()
    private lateinit var binding: FragmentChooseLanguageBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentChooseLanguageBinding.bind(view)
        binding.apply {
            chooseLanguageLayoutEng.setOnClickListener {
                setLocale("hi")
                languageSelectedUIChanges(eng = true)
                viewModel.englishLanguageLayoutClicked()
            }

            chooseLanguageLayoutHindi.setOnClickListener {
                languageSelectedUIChanges(eng = false)
                viewModel.hindiLanguageLayoutClicked()
            }

            chooseLangButton.setOnClickListener {
                languageSelectedUIChanges(eng = true)
                viewModel.englishLanguageLayoutClicked()
            }
        }
        setupEvents()
    }

    // Util Functions
    private fun languageSelectedUIChanges(eng: Boolean) {
        binding.apply {
            if (eng) {
                chooseLanguageRadioEng.isChecked = true
                chooseLanguageRadioHin.isChecked = false

            } else {
                chooseLanguageRadioHin.isChecked = true
                chooseLanguageRadioEng.isChecked = false
            }
        }
    }

    private fun setLocale(s: String) {
        val locale: Locale = Locale(s)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    private fun setupEvents() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.eventsFlow.collect { events ->
                when (events) {
                    ChooseLangEvents.MoveToLoginFragment -> {
                        val directions =
                            FragmentChooseLanguageDirections.actionFragmentChooseLanguageToFragmentLogin()
                        findNavController().navigate(directions)
                    }
                }
            }
        }
    }
}