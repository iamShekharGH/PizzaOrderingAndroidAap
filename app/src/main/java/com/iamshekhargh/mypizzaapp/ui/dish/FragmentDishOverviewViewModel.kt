package com.iamshekhargh.mypizzaapp.ui.dish

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import javax.inject.Inject

@HiltViewModel
class FragmentDishOverviewViewModel @Inject constructor() : ViewModel() {

    private val events = Channel<DishOverviewEvents>()
    val eventsFlow = events.consumeAsFlow()

}

sealed class DishOverviewEvents {

}