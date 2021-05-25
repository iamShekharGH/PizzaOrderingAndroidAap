package com.iamshekhargh.mypizzaapp.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamshekhargh.mypizzaapp.repo.PizzaDeliveryRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FragmentDashboardViewModel @Inject constructor(
    val repo: PizzaDeliveryRepo
) : ViewModel() {

    private val events = Channel<FragmentDashboardEvents>()
    val eventFlow = events.consumeAsFlow()

    fun dineInRadioClicked() {
        gotoNextFrag()
    }

    fun takeawayRadioClicked() {
        gotoNextFrag()
    }

    private fun gotoNextFrag() = viewModelScope.launch {
        delay(3000)
        events.send(FragmentDashboardEvents.OpenMenu(0))
    }

    fun requestDashboardInformation() = viewModelScope.launch {
        repo.requestDashboardInformation()

    }
}

sealed class FragmentDashboardEvents {
    // Make enum of tab names and pass that. For now int.
    data class OpenMenu(val position: Int) : FragmentDashboardEvents()

}