package com.example.myapplication.unit4.desertClicker

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.example.myapplication.unit4.desertClicker.DataSource.dessertList

class DessertViewModel : ViewModel() {

    private val _dessertUiState = MutableStateFlow(DessertUIState())
    val dessertUIState = _dessertUiState.asStateFlow()

    fun onDessertClicked() {
        _dessertUiState.update { cupcakeUiState ->
            val dessertsSold = cupcakeUiState.dessertSold + 1
            val nextDessertIndex = determineDessertIndex(dessertsSold)
            cupcakeUiState.copy(
                currentDessertIndex = nextDessertIndex,
                totalRevenue = cupcakeUiState.totalRevenue + cupcakeUiState.currentDessertPrice,
                dessertSold = dessertsSold,
                currentDessertImage = dessertList[nextDessertIndex].imageId,
                currentDessertPrice = dessertList[nextDessertIndex].price
            )
        }
    }

    private fun determineDessertIndex(dessertsSold: Int): Int {
        var dessertIndex = 0
        for (index in dessertList.indices) {
            if (dessertsSold >= dessertList[index].startProductionAmount) {
                dessertIndex = index
            } else {
                break
            }
        }
        return dessertIndex
    }
}