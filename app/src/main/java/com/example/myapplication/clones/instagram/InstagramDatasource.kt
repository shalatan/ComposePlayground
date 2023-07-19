package com.example.myapplication.clones.instagram

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Grid4x4
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ScreenShare
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material.icons.filled.VideoFile
import androidx.compose.material.icons.filled.VideoLibrary
import com.example.myapplication.R
import com.example.myapplication.clones.instagram.model.IconWithText
import com.example.myapplication.clones.instagram.model.StoryHighlight

object InstagramDatasource {

    const val userId = "shalatan.heif"
    const val userName = "Shashank Singh"
    const val userBio =
        "Introvert traveller, who rarely goes out to travel.\nSubscribe and follow for more."
    const val userUrl = "shalatan.github.io"

    val highlights = listOf<StoryHighlight>(
        StoryHighlight(image = R.drawable.android_superhero1, text = "Robot"),
        StoryHighlight(image = R.drawable.android_superhero2, text = "CatWoman"),
        StoryHighlight(image = R.drawable.android_superhero3, text = "Flash"),
        StoryHighlight(image = R.drawable.android_superhero4, text = "Batman"),
        StoryHighlight(image = R.drawable.android_superhero5, text = "IceWhite"),
        StoryHighlight(image = R.drawable.android_superhero6, text = "Curly")
    )

    val homeTabs = listOf<IconWithText>(
        IconWithText(vector = Icons.Default.Home, text = "Home"),
        IconWithText(vector = Icons.Default.Explore, text = "Explore"),
        IconWithText(vector = Icons.Default.VideoLibrary, text = "Reels"),
        IconWithText(vector = Icons.Default.Person, text = "Profile")
    )

    val profileTabs = listOf<IconWithText>(
        IconWithText(vector = Icons.Default.Grid4x4, text = "Posts"),
        IconWithText(vector = Icons.Default.VideoFile, text = "Reels"),
        IconWithText(vector = Icons.Default.Tv, text = "IGTV"),
        IconWithText(vector = Icons.Default.ScreenShare, text = "Shares")
    )

    val posts = listOf<Int>(
        R.drawable.dog_bella,
        R.drawable.topic_fashion,
        R.drawable.dog_koda,
        R.drawable.topic_film,
        R.drawable.topic_tech,
        R.drawable.dog_faye,
        R.drawable.dog_frankie,
        R.drawable.affirm_2,
        R.drawable.affirm_3,
        R.drawable.dog_nox,
        R.drawable.topic_architecture,
        R.drawable.affirm_4,
        R.drawable.dog_tzeitel,
        R.drawable.topic_gaming,
    )
}