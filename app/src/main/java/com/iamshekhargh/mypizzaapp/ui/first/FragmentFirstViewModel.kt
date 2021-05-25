package com.iamshekhargh.mypizzaapp.ui.first

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamshekhargh.mypizzaapp.repo.FirstFragEvent
import com.iamshekhargh.mypizzaapp.repo.PizzaDeliveryRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FragmentFirstViewModel @Inject constructor(
    private val repo: PizzaDeliveryRepo
) : ViewModel() {

    private val events = Channel<FirstFragmentEvents>()
    val eventsFlow = events.consumeAsFlow()

    fun downloadResources() = viewModelScope.launch {
        //here make the call
        delay(3000)
        repo.loadResourcesInitialStart()
        events.send(FirstFragmentEvents.OpenLoginFragment)
    }

    fun listenToRepoEvents() = viewModelScope.launch {
        repo.repoChannelFlow.collect { event ->
            when (event) {
                is FirstFragEvent.FirstFragResourcesLoaded -> {
                    events.send(FirstFragmentEvents.OpenLoginFragment)
                }
            }
        }
    }
}

sealed class FirstFragmentEvents() {
    object OpenLoginFragment : FirstFragmentEvents()
}