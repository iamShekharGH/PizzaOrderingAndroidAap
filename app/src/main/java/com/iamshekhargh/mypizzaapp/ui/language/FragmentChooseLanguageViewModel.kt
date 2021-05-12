package com.iamshekhargh.mypizzaapp.ui.language

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FragmentChooseLanguageViewModel @Inject constructor() : ViewModel() {

    private val events = Channel<ChooseLangEvents>()
    val eventsFlow = events.consumeAsFlow()

    fun englishLanguageLayoutClicked() {
        loadLoginFragment()
    }

    fun hindiLanguageLayoutClicked() {
        loadLoginFragment()
    }

    private fun loadLoginFragment() = viewModelScope.launch {
        getUserLocation()
        delay(2000)
        events.send(ChooseLangEvents.MoveToLoginFragment)
    }

    private fun getUserLocation() = viewModelScope.launch {

    }
}

sealed class ChooseLangEvents {
    object MoveToLoginFragment : ChooseLangEvents()

}