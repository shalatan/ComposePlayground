package com.example.myapplication.clones.instagram.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.clones.instagram.InstagramDatasource
import com.example.myapplication.clones.instagram.RoundImage
import com.example.myapplication.clones.instagram.UserAction
import com.example.myapplication.clones.instagram.UserActionWithText
import com.example.myapplication.clones.instagram.model.InstagramReel
import com.example.myapplication.clones.instagram.theme.InstagramTheme

@Preview(showBackground = true)
@Composable
fun ReelsScreenPreview() {
    InstagramTheme {
        ReelsScreen(modifier = Modifier, InstagramDatasource.sampleReels[0])
//        ReelFooterSection(reel = InstagramDatasource.sampleReels[0])
    }
}

@Composable
fun ReelsScreen(modifier: Modifier = Modifier, reel: InstagramReel) {
    Box(modifier = modifier.fillMaxSize(1f)) {
        Image(
            painter = painterResource(id = reel.image),
            contentDescription = "reel",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        val topGradient = Brush.verticalGradient(listOf(Color.Black, Color.Transparent))
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .height(150.dp)
                .fillMaxWidth()
                .background(topGradient)
        )
        val bottomGradient = Brush.verticalGradient(listOf(Color.Transparent, Color.Black))
        Box(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .background(bottomGradient)
                .align(Alignment.BottomCenter)
        )
        Column(modifier = Modifier.align(Alignment.BottomStart)) {
            ReelFooterSection(reel)
        }
    }
}

@Composable
fun ReelFooterSection(reel: InstagramReel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp, start = 16.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        ReelFooterUserData(reel, modifier = Modifier.weight(8f))
        ReelFooterUserActions(reel, modifier = Modifier.weight(2f))
    }
}

@Composable
fun ReelFooterUserActions(reel: InstagramReel, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(top = 32.dp)
    ) {
        UserAction(
            drawableRes = R.drawable.ic_insta_camera,
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        UserActionWithText(drawableRes = R.drawable.ig_heart_empty, text = reel.likes.toString())
        Spacer(modifier = Modifier.height(16.dp))
        UserActionWithText(
            drawableRes = R.drawable.ic_insta_comment,
            text = reel.comments.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        UserActionWithText(drawableRes = R.drawable.ic_insta_dm, text = reel.shares.toString())
        Spacer(modifier = Modifier.height(16.dp))
        Icon(imageVector = Icons.Default.MoreVert, contentDescription = null, tint = Color.White)
        Spacer(modifier = Modifier.height(16.dp))
        RoundImage(
            image = painterResource(id = reel.userProfileImage),
            unseen = false,
            modifier = Modifier
                .size(24.dp)
                .clip(RoundedCornerShape(6.dp))
        )
    }
}

@Composable
fun ReelFooterUserData(reel: InstagramReel, modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.Start) {
        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
            RoundImage(
                image = painterResource(id = reel.userProfileImage),
                unseen = true,
                modifier = Modifier.size(44.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = reel.userId,
                color = Color.White,
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Follow",
                color = Color.White,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .border(1.dp, Color.White, RoundedCornerShape(4.dp))
                    .padding(4.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = reel.caption,
            color = Color.White,
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = reel.audioName,
            color = Color.White,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .background(Color(0xA8, 0xA8, 0xA8, 0x41), RoundedCornerShape(8.dp))
                .padding(horizontal = 8.dp, vertical = 1.dp)
        )
    }
}
