package com.example.myapplication.clones.instagram.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.clones.instagram.HighlightSection
import com.example.myapplication.clones.instagram.RoundImage
import com.example.myapplication.clones.instagram.model.InstagramPost
import com.example.myapplication.clones.instagram.theme.InstagramTheme
import com.example.myapplication.clones.instagram.InstagramDatasource as data

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    InstagramTheme {
        HomeScreen()
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.scrollable(rememberScrollState(), Orientation.Vertical)) {
//    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        HighlightSection(
            highlights = data.highlights,
            unseen = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )
        HomeFeedSection(modifier = Modifier, posts = data.samplePosts)
    }
}

@Composable
fun HomeFeedSection(modifier: Modifier = Modifier, posts: List<InstagramPost>) {
    LazyColumn(modifier = modifier) {
        items(posts) { post ->
            InstagramPostItem(post = post)
        }
    }
}

@Composable
fun InstagramPostItem(modifier: Modifier = Modifier, post: InstagramPost) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundImage(
                image = painterResource(id = post.userProfileImage),
                unseen = false,
                modifier = Modifier
                    .size(32.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = post.userId, fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.width(8.dp))
            if (post.isVerified) {
                Image(
                    painter = painterResource(id = R.drawable.ic_insta_verified),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = null,
            )
        }
        Image(
            painter = painterResource(post.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(200.dp, 400.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            Row(modifier = Modifier.weight(9f)) {
                Icon(
                    painter = painterResource(id = R.drawable.ig_heart_empty),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_insta_comment),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ig_send),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ig_save_empty),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .size(24.dp)
                    .weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "${post.likes} likes", fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = post.userId, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = post.caption)
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "View all ${post.comments} comments",
            color = Color.Gray,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = post.time,
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
    }
}
