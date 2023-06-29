package com.example.myapplication.unit4.desertClicker

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DessertViewModel : ViewModel() {

    private val _dessertUiState = MutableStateFlow(DessertUIState())
    val dessertUIState = _dessertUiState.asStateFlow()

    fun updateUIState(quantity: Int, price: Int) {
        _dessertUiState.value.totalRevenue.plus(price)
        _dessertUiState.value.dessertSold.plus(quantity)
    }
}