package com.example.myapplication.clones.instagram.model

data class InstagramPost(
    val username: String,
    val imageUrl: String,
    val likes: Int,
    val comments: Int,
    val time: String
)
