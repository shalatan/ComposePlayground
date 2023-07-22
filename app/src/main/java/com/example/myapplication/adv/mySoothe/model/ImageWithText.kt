package com.example.myapplication.adv.mySoothe.model

import androidx.annotation.DrawableRes

data class ImageWithText(
    @DrawableRes
    val image: Int,
    val text: String
)