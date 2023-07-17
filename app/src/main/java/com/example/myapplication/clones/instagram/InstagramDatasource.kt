package com.example.myapplication.clones.instagram

import com.example.myapplication.R
import com.example.myapplication.clones.instagram.model.StoryHighlight

object InstagramDatasource {

    const val userId = "shalatan.heif"
    const val userName = "Shashank Singh"
    const val userBio = "Introvert traveller, who rarely goes out to travel.\nSubscribe and follow for more."
    const val userUrl = "shalatan.github.io"

    val highlights = listOf<StoryHighlight>(
        StoryHighlight(image = R.drawable.dice_1, text = "Dice 1"),
        StoryHighlight(image = R.drawable.dice_2, text = "Dice 2"),
        StoryHighlight(image = R.drawable.dice_3, text = "Dice 3"),
        StoryHighlight(image = R.drawable.dice_4, text = "Dice 4"),
        StoryHighlight(image = R.drawable.dice_5, text = "Dice 5"),
        StoryHighlight(image = R.drawable.dice_6, text = "Dice 6")
    )
}