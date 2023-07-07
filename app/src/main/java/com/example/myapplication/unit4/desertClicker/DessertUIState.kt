package com.example.myapplication.unit4.desertClicker

import androidx.annotation.DrawableRes
import com.example.myapplication.unit4.desertClicker.DataSource.dessertList

data class DessertUIState(
    val currentDessertIndex: Int = 0,
    val dessertSold: Int = 0,
    val totalRevenue: Int = 0,
    val currentDessertPrice: Int = dessertList[currentDessertIndex].price,
    @DrawableRes
    val currentDessertImage: Int = dessertList[currentDessertIndex].imageId
)