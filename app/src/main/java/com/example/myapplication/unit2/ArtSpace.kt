package com.example.myapplication.unit2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.material3Theme.MyApplicationMaterial3Theme
import com.example.myapplication.R

data class Art(val title: String, val artist: String, val image: Int, val year: Int)

class ArtSpace : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val arts = listOf<Art>(
            Art("Code Haha", "Pablo Singh", R.drawable.dice_1, 1875),
            Art("Code Haha Haha", "Da Vinci Singh", R.drawable.dice_2, 1709),
            Art("Code Haha Haha Haha", "Von Singh", R.drawable.dice_3, 1400),
            Art("Code Haha Haha Haha Haha", "Picasso Singh", R.drawable.dice_4, 2025),
        )
        setContent {
            MyApplicationMaterial3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceScreen(arts = arts, modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(arts: List<Art>, modifier: Modifier = Modifier) {
    var position by remember { mutableStateOf(0) }
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtImage(art = arts[position], modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(64.dp))
        ArtInformationSection(art = arts[position])
        Spacer(modifier = Modifier.height(32.dp))
        ButtonsLayout(
            onPreviousClick = {
                if (position != 0)
                    position--
            }, onNextClick = {
                if (position != arts.size - 1)
                    position++
            }, modifier = Modifier
        )
    }
}

@Composable
fun ArtImage(art: Art, modifier: Modifier = Modifier) {
    Surface(modifier = modifier, shadowElevation = 8.dp) {
        Image(
            painter = painterResource(id = art.image),
            contentDescription = "Art Image",
            modifier = modifier.padding(16.dp)
        )
    }
}

@Composable
fun ArtInformationSection(art: Art, modifier: Modifier = Modifier) {
    val infoText = "${art.artist} (${art.year})"
    Surface(
        modifier = modifier
            .fillMaxWidth(),
        tonalElevation = 4.dp,
        color = Color(0xFFE9D2FF),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = art.title, fontSize = 24.sp)
            Text(text = infoText, fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun ButtonsLayout(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            Text(text = "Previous", color = Color.White)
        }
        Button(
            onClick = onNextClick,
            modifier = modifier
                .weight(1f)
                .padding(8.dp),
        ) {
            Text(text = "Next", color = Color.White)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview9() {
    MyApplicationMaterial3Theme {
        val arts = listOf<Art>(
            Art("Code Haha", "Pablo Singh", R.drawable.dice_1, 1875),
            Art("Code Haha Haha", "Da Vinci Singh", R.drawable.dice_2, 1709),
            Art("Code Haha Haha Haha", "Von Singh", R.drawable.dice_3, 1400),
            Art("Code Haha Haha Haha Haha", "Picasso Singh", R.drawable.dice_4, 2025),
        )
        ArtSpaceScreen(arts = arts, modifier = Modifier)
    }
}