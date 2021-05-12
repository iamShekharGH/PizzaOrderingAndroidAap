package com.iamshekhargh.mypizzaapp.ui.first

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FragmentFirstViewModel @Inject constructor() : ViewModel() {

    private val events = Channel<FirstFragmentEvents>()
    val eventsFlow = events.consumeAsFlow()


    fun downloadResources() = viewModelScope.launch {
        //here make the call
        delay(3000)
        events.send(FirstFragmentEvents.OpenLoginFragment)
    }

}

sealed class FirstFragmentEvents() {
    object OpenLoginFragment : FirstFragmentEvents()
}