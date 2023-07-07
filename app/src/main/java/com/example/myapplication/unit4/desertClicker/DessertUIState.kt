package com.example.myapplication.unit4.desertClicker

import androidx.annotation.DrawableRes

data class DessertUIState(
    val dessertSold: Int = 0,
    val totalRevenue: Int = 0,
    val currentDessertPrice: Int = 0,
    val currentDessertIndex: Int = 0,
    @DrawableRes
    val currentDessertImage: Int = 0
)