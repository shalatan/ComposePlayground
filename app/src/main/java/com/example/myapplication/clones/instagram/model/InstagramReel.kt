package com.example.myapplication.clones.instagram.model

import androidx.annotation.DrawableRes

data class InstagramReel(
    val userId: String,
    @DrawableRes
    val userProfileImage: Int,
    @DrawableRes
    val image: Int,
    val caption: String,
    val likes: Int,
    val comments: Int,
    val shares: Int,
    val time: String,
)
