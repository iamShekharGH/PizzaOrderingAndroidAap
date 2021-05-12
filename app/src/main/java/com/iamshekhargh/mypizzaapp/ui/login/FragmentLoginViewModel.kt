package com.iamshekhargh.mypizzaapp.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FragmentLoginViewModel @Inject constructor() : ViewModel() {

    private val events = Channel<FragmentLoginEvents>()
    val eventFlow = events.consumeAsFlow()

    fun loginSkipped() = viewModelScope.launch {
        events.send(FragmentLoginEvents.LoadDashboard)
    }
}

sealed class FragmentLoginEvents {

    object LoadDashboard : FragmentLoginEvents()
}