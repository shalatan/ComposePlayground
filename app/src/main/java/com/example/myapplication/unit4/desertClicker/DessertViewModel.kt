package com.example.myapplication.unit4.desertClicker

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.example.myapplication.unit4.desertClicker.DataSource.dessertList


class DessertViewModel : ViewModel() {

    private val _dessertUiState = MutableStateFlow(DessertUIState())
    val dessertUIState = _dessertUiState.asStateFlow()

    private var currentDessertIndex: Int = 0

    fun onDessertClicked() {
        Log.e("LOGG", "before: ${dessertUIState.value}")
        _dessertUiState.update { dessertUIState ->
            val dessertSold = dessertUIState.dessertSold + 1
            updateCurrentDessert(dessertSold)
            dessertUIState.copy(
                currentDessertIndex = currentDessertIndex,
                dessertSold = dessertSold,
                totalRevenue = dessertUIState.totalRevenue + dessertUIState.currentDessertPrice,
                currentDessertImage = dessertList[currentDessertIndex].imageId,
                currentDessertPrice = dessertList[currentDessertIndex].imageId,
            )
        }
        Log.e("LOGG", "after: ${dessertUIState.value}")
    }

    private fun updateCurrentDessert(dessertsSold: Int) {
        Log.e("LOGG", "currentDessertIndex: $currentDessertIndex")
        if (dessertsSold >= dessertList[currentDessertIndex + 1].startProductionAmount) {
            currentDessertIndex += 1
            Log.e("LOGG", "currentDessertIndexAfter: $currentDessertIndex")
        }
    }

    fun determineDessertToShow(
        dessertsSold: Int
    ): Int {
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

    fun updateUIState(quantity: Int, price: Int) {

        _dessertUiState.value.totalRevenue.plus(price)
        _dessertUiState.value.dessertSold.plus(quantity)
    }
}