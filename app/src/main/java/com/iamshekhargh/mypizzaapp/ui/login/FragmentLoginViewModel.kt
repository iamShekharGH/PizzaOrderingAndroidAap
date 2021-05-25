package com.iamshekhargh.mypizzaapp.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamshekhargh.mypizzaapp.repo.PizzaDeliveryRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FragmentLoginViewModel @Inject constructor(
    private val repo: PizzaDeliveryRepo
) : ViewModel() {

    private val events = Channel<FragmentLoginEvents>()
    val eventFlow = events.consumeAsFlow()

    fun loginSkipped() = viewModelScope.launch {
        events.send(FragmentLoginEvents.LoadDashboard)
    }

    fun submitButtonClicked(phoneNumber: String) = viewModelScope.launch {
        if (phoneNumber.isEmpty() || phoneNumber.length != 10) {
            events.send(FragmentLoginEvents.PhoneNumberWrong("The phone number entered is incorrect!"))
        } else {
            repo.sendPhoneNumber(phoneNumber)
        }
    }
}

sealed class FragmentLoginEvents {

    data class PhoneNumberWrong(val text: String) : FragmentLoginEvents()
    object LoadDashboard : FragmentLoginEvents()
}