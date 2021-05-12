package com.iamshekhargh.mypizzaapp.ui.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FragmentMenuViewModel @Inject constructor() : ViewModel() {

    private val events = Channel<FragmentMenuEvents>()
    val eventFlow = events.consumeAsFlow()

    val tabList = mutableListOf<String>()

    init {
        tabList.add("Bestseller")
        tabList.add("Pizza Pasta Party")
        tabList.add("Veg Pizza")
        tabList.add("Non-Veg Pizza")
        tabList.add("Meals & Combos")
        tabList.add("Pizza Mania")
        tabList.add("Speciality Chicken")
        tabList.add("Sides")
        tabList.add("Beverages")
        tabList.add("Dessert")
        tabList.add("Daily Essentials")
        tabList.add("Favourite")
    }

    fun openNext() = viewModelScope.launch {
        delay(2000)
        events.send(FragmentMenuEvents.ShowDishOverview("This"))
    }

}

sealed class FragmentMenuEvents {

    data class ShowDishOverview(val id: String) : FragmentMenuEvents()

}