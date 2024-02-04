package com.example.myapplication.clones.instagram

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.clones.instagram.model.StoryHighlight

@Preview
@Composable
fun CommonUiPreview() {
//    HighlightSection(unseen = true, highlights = InstagramDatasource.highlights)
    RoundImage(image = painterResource(id = R.drawable.dog_bella), true)
//    UserActionWithText(drawableRes = R.drawable.ig_heart_empty, text = "Like")
}

@Composable
fun UserAction(@DrawableRes drawableRes: Int, modifier: Modifier = Modifier) {
    Icon(
        bitmap = ImageBitmap.imageResource(id = drawableRes),
        tint = Color.White,
        modifier = modifier.size(16.dp),
        contentDescription = null
    )
}

@Composable
fun UserActionWithText(
    @DrawableRes drawableRes: Int,
    text: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
    ) {
        Icon(
            bitmap = ImageBitmap.imageResource(id = drawableRes),
            tint = Color.White,
            modifier = Modifier.size(28.dp),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = text,
            color = Color.White,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun RoundImage(
    image: Painter,
    unseen: Boolean,
    modifier: Modifier = Modifier
) {
    val colors: List<Color> = if (unseen) {
        listOf(
            Color(0xFF9575CD),
            Color(0xFFBA68C8),
            Color(0xFFE57373),
            Color(0xFFFFB74D),
            Color(0xFF9575CD),
        )
    } else {
        listOf(Color.Gray, Color.LightGray)
    }

    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
//            .border(width = 4.dp, brush = Brush.radialGradient(colors), shape = CircleShape)
            .border(
                BorderStroke(2.dp, Brush.sweepGradient(colors)), CircleShape
            )
            .padding(4.dp)
            .clip(CircleShape)
    )
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    unseen: Boolean,
    highlights: List<StoryHighlight>
) {
    LazyRow(modifier = modifier, contentPadding = PaddingValues(horizontal = 16.dp)) {
        items(highlights) {
            SingleHighlight(
                storyHighlight = it,
                unseen = unseen,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun SingleHighlight(
    storyHighlight: StoryHighlight,
    unseen: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RoundImage(
            image = painterResource(id = storyHighlight.image),
            unseen = unseen,
            modifier = Modifier.size(70.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = storyHighlight.text,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}