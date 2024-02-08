package com.example.myapplication.clones.instagram.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.clones.instagram.InstagramDatasource
import com.example.myapplication.clones.instagram.model.InstagramPost

@Preview
@Composable
fun ExplorePreview() {
    ExploreScreen()
}

@Composable
fun ExploreScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        ExplorePostSection(items = InstagramDatasource.samplePosts)
    }
}

@Composable
fun ExplorePostSection(modifier: Modifier = Modifier, items: List<InstagramPost>) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(3),
        modifier = modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalItemSpacing = 4.dp
    ) {
        items(items) {
            ExploreItem(post = it)
        }
    }
}

@Composable
fun ExploreItem(post: InstagramPost, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = post.image),
        contentScale = ContentScale.Crop,
        contentDescription = null,
        modifier = modifier
            .heightIn(100.dp, 200.dp)
    )
}
