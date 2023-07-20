package com.example.myapplication.clones.instagram.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.clones.instagram.model.IconWithText
import com.example.myapplication.clones.instagram.InstagramDatasource as data
import com.example.myapplication.clones.instagram.model.StoryHighlight
import com.example.myapplication.clones.instagram.theme.InstagramTheme

@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    InstagramTheme {
        ProfileScreen()
    }
}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        ProfileDetailSection()
        Spacer(modifier = Modifier.height(8.dp))
        ButtonSection(modifier = Modifier)
        Spacer(modifier = Modifier.height(16.dp))
        HighlightSection(
            highlights = data.highlights,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
//            PostTabView(imageWithTexts = data.profileTabs,
//                onTabSelected = { selectedIndex: Int ->
//                })
        PostTabView(imageWithTexts = data.profileTabs) { selectedIndex ->
            selectedTabIndex = selectedIndex
            when (selectedTabIndex) {
                0 -> {

                }

                1 -> {
                }

                2 -> {
                }

                3 -> {
                }
            }
        }
        PostSection(posts = data.posts)
    }
}

@Composable
fun ProfileDetailSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.dog_bella),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            ProfileStatSection(modifier = Modifier.weight(7f))
        }
        Spacer(modifier = Modifier.height(8.dp))
        ProfileDescription(
            userDisplayName = data.userName,
            userDescription = data.userBio,
            userLink = data.userUrl,
            followedBy = listOf("charles babbage", "john v neuman"),
            otherCount = 88
        )
    }
}

@Composable
fun ProfileStatSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ProfileStats(number = "69", name = "Posts")
        ProfileStats(number = "69.9", name = "Followers")
        ProfileStats(number = "96", name = "Following")
    }
}

@Composable
fun ProfileStats(number: String, name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = number, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = modifier.height(8.dp))
        Text(text = name, fontSize = 16.sp)
    }
}

@Composable
fun ProfileDescription(
    userDisplayName: String,
    userDescription: String,
    userLink: String,
    followedBy: List<String>,
    otherCount: Int,
    modifier: Modifier = Modifier
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = userDisplayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = userDescription, letterSpacing = letterSpacing, lineHeight = lineHeight
        )
        Text(
            text = userLink,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black, fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                }, letterSpacing = letterSpacing, lineHeight = lineHeight
            )
        }
    }

}

@Composable
fun RoundImage(image: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(width = 1.dp, color = Color.LightGray, shape = CircleShape)
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun ButtonSection(modifier: Modifier) {
    Row(modifier = modifier.padding(horizontal = 18.dp)) {
        ActionButton(Modifier.weight(3f), "Following", Icons.Default.KeyboardArrowDown)
        ActionButton(Modifier.weight(3f), "Message")
        ActionButton(Modifier.weight(3f), "Email")
        ActionButton(Modifier.weight(1f), icon = Icons.Default.KeyboardArrowDown)
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier, text: String? = null, icon: ImageVector? = null
) {
    OutlinedButton(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(5.dp),
        modifier = modifier
            .padding(2.dp)
            .height(36.dp)
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (text != null) {
                Text(
                    text = text,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.width(2.dp))
            if (icon != null) {
                Icon(imageVector = icon, contentDescription = null, tint = Color.Black)
            }
        }
    }
}

@Composable
fun HighlightSection(modifier: Modifier = Modifier, highlights: List<StoryHighlight>) {
    LazyRow(modifier = modifier) {
        items(highlights) {
            SingleHighlight(storyHighlight = it, modifier = Modifier)
        }
    }
}

@Composable
fun SingleHighlight(storyHighlight: StoryHighlight, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(end = 16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RoundImage(
            image = painterResource(id = storyHighlight.image), modifier = Modifier.size(70.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = storyHighlight.text,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<IconWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithTexts.forEachIndexed { index, item ->
            Tab(selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    imageVector = item.vector,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@Composable
fun PostSection(
    posts: List<Int>, modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        //to hide the paddings on the corner sides of posts
        modifier = modifier.scale(1.01f)
    ) {
        items(posts) {
            Image(
                painter = painterResource(id = it),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(1.dp, color = Color.White)
            )
        }
    }
}