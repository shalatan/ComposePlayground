package com.example.myapplication.clones.instagram

import com.example.myapplication.R
import com.example.myapplication.adv.mySoothe.model.ImageWithText
import com.example.myapplication.clones.instagram.model.InstagramPost
import com.example.myapplication.clones.instagram.model.InstagramReel
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

    val homeTabs = listOf<ImageWithText>(
        ImageWithText(image = R.drawable.ic_insta_home, text = "Home"),
        ImageWithText(image = R.drawable.ic_insta_search, text = "Explore"),
        ImageWithText(image = R.drawable.ic_insta_add, text = "Add"),
        ImageWithText(image = R.drawable.ic_insta_reel, text = "Reels"),
        ImageWithText(image = R.drawable.ic_insta_profile, text = "Profile")
    )

    val profileTabs = listOf<ImageWithText>(
        ImageWithText(image = R.drawable.ic_insta_grid, text = "Posts"),
        ImageWithText(image = R.drawable.ic_insta_reel, text = "Reels"),
        ImageWithText(image = R.drawable.ic_insta_igtv, text = "IGTV"),
        ImageWithText(image = R.drawable.ic_insta_reel, text = "Shares")
    )

    val samplePosts = listOf<InstagramPost>(
        InstagramPost(
            "bella",
            R.drawable.android_superhero1,
            R.drawable.dog_bella,
            "White dog chilling on small rocks",
            300,
            8,
            "4 hours ago",
            true
        ),
        InstagramPost(
            "bella",
            R.drawable.android_superhero2,
            R.drawable.affirm_2,
            "Dog with band he..",
            4,
            89,
            "1 hours ago",
            false
        ),
        InstagramPost(
            "bella",
            R.drawable.android_superhero2,
            R.drawable.topic_fashion,
            "Fashion day, LGTV",
            0,
            1,
            "2 day ago",
            true
        ),
        InstagramPost(
            "bella",
            R.drawable.android_superhero4,
            R.drawable.topic_architecture,
            "Very big building, but looks average",
            24,
            9,
            "21 hours ago",
            false
        ),
        InstagramPost(
            "bella",
            R.drawable.android_superhero3,
            R.drawable.dog_lola,
            "Dog darker than your future",
            200,
            33,
            "23 minutes ago",
            false
        ),
        InstagramPost(
            "bella",
            R.drawable.android_superhero5,
            R.drawable.topic_crafts,
            "Craft-man-ship",
            311,
            8,
            "5 hours ago",
            false
        ),
        InstagramPost(
            "bella",
            R.drawable.android_superhero6,
            R.drawable.topic_lifestyle,
            "No lifestyle for developers",
            0,
            0,
            "12 hours ago",
            false
        ),
        InstagramPost(
            "bella",
            R.drawable.android_superhero1,
            R.drawable.affirm_5,
            "Take one more gyaan",
            32,
            4,
            "3 days ago",
            false
        ),
        InstagramPost(
            "bella",
            R.drawable.android_superhero5,
            R.drawable.dog_koda,
            "New dog",
            34,
            88,
            "5 hours ago",
            false
        ), InstagramPost(
            "bella",
            R.drawable.android_superhero1,
            R.drawable.lemon_tree,
            "New dog",
            34,
            88,
            "5 hours ago",
            false
        ),
        InstagramPost(
            "bella",
            R.drawable.android_superhero2,
            R.drawable.dog_faye,
            "New dog",
            34,
            88,
            "5 hours ago",
            true
        ),
        InstagramPost(
            "bella",
            R.drawable.android_superhero2,
            R.drawable.topic_fashion,
            "New dog",
            34,
            88,
            "5 hours ago",
            true
        ),
        InstagramPost(
            "bella",
            R.drawable.android_superhero4,
            R.drawable.topic_architecture,
            "New dog",
            34,
            88,
            "5 hours ago",
            false
        ),
        InstagramPost(
            "bella",
            R.drawable.android_superhero6,
            R.drawable.topic_crafts,
            "New dog",
            34,
            88,
            "5 hours ago",
            false
        ),
        InstagramPost(
            "bella",
            R.drawable.android_superhero1,
            R.drawable.dog_tzeitel,
            "New dog",
            34,
            88,
            "5 hours ago",
            false
        )
    )

    val sampleReels = listOf<InstagramReel>(
        InstagramReel(
            "frankie",
            R.drawable.android_superhero1,
            R.drawable.dog_frankie,
            "White dog",
            300,
            8,
            23,
            "4 hours ago",
            "frankies - Original audio"
        ),
        InstagramReel(
            "koda",
            R.drawable.android_superhero6,
            R.drawable.dog_koda,
            "Kutte ka naam koda hei",
            532,
            88,
            235,
            "4 hours ago",
            "koda - Original audio"
        )
    )

    val profilePosts = listOf<Int>(
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