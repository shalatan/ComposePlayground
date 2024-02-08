package com.example.myapplication.clones.instagram

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.adv.mySoothe.model.ImageWithText
import com.example.myapplication.clones.instagram.InstagramDatasource
import com.example.myapplication.clones.instagram.model.IconWithText
import com.example.myapplication.clones.instagram.theme.InstagramTheme
import com.example.myapplication.clones.instagram.ui.ExploreScreen
import com.example.myapplication.clones.instagram.ui.HomeScreen
import com.example.myapplication.clones.instagram.ui.ProfileScreen
import com.example.myapplication.clones.instagram.ui.ReelsScreen
import com.example.myapplication.clones.instagram.InstagramDatasource as data

class InstagramActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    InstagramApp()
                }
            }
        }
    }
}

@Composable
fun InstagramApp(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    var selectedBottomTab by rememberSaveable {
        mutableIntStateOf(0)
    }
    Log.e("HELPME", "updated selectedBottomTab to $selectedBottomTab")
    Scaffold(
        topBar = {
            InstagramAppBar(
                name = when (selectedBottomTab) {
                    0 -> "Instagram"
                    1 -> "Explore"
                    2 -> "Add"
                    3 -> "Reels"
                    4 -> data.userId
                    else -> {
                        "Instagram"
                    }
                }
            )
        },
        bottomBar = {
            BottomNav(navController = navController,
                tabs = data.homeTabs,
                onClick = { clickedIndex ->
                    selectedBottomTab = clickedIndex
                })
        },
    ) { paddingValues ->
        when (selectedBottomTab) {
            0 -> {
                HomeScreen(modifier = Modifier.padding(paddingValues))
            }

            1 -> {
                ExploreScreen(modifier = Modifier.padding(paddingValues))
            }

            2 -> {

            }

            3 -> {
                ReelsScreen(
                    modifier = Modifier.padding(paddingValues),
                    InstagramDatasource.sampleReels[0]
                )
            }

            4 -> {
                ProfileScreen(modifier = Modifier.padding(paddingValues))
            }
        }
    }
}

@Composable
fun BottomNav(
    navController: NavController,
    tabs: List<ImageWithText>,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.White
    ) {
        tabs.forEachIndexed { index, screen ->
            val selected = selectedTabIndex == index
            BottomNavigationItem(icon = {
                Icon(
                    painterResource(id = screen.image),
                    contentDescription = screen.text,
                    tint = if (selected) Color.Black else Color.Gray,
                    modifier = modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }, selected = selectedTabIndex == index, onClick = {
                selectedTabIndex = index
                onClick(index)
            })
        }
    }
}

@Composable
fun InstagramAppBar(name: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
//        Icon(
//            imageVector = Icons.Default.ArrowBack,
//            contentDescription = "Back",
//            tint = Color.Black,
//            modifier = Modifier
//                .size(24.dp)
//                .weight(1f)
//        )
//        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic,
            fontSize = 24.sp,
            letterSpacing = 0.5.sp,
            modifier = Modifier.weight(8f)
        )
        Image(
            painter = painterResource(id = R.drawable.ig_heart_empty),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_insta_dm),
            contentDescription = null,
            modifier = Modifier
                .size(26.dp)
                .weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    InstagramTheme {
        InstagramApp()
    }
}