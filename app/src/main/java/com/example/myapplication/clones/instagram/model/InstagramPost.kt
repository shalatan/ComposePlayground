package com.example.myapplication.clones.instagram.model

import androidx.annotation.DrawableRes

data class InstagramPost(
    val userId: String,
    @DrawableRes
    val userProfileImage: Int,
    @DrawableRes
    val image: Int,
    val caption: String,
    val likes: Int,
    val comments: Int,
    val time: String,
)
