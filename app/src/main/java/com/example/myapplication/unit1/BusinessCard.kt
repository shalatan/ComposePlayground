package com.example.myapplication.unit1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.unit1.ui.theme.MyApplicationTheme

class BusinessCard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen() {
    Column {
        InfoCard()
        ContactCard()
    }
}

@Composable
fun InfoCard(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.androidparty),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(40.dp)
        )
        Text(text = "Shashank Singh", fontSize = 24.sp)
        Text(text = "Android Developer", fontSize = 16.sp)
    }
}

@Composable
fun ContactCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactInformation(
            icon = Icons.Filled.Menu,
            info = "+91 987543321"
        )
        ContactInformation(
            icon = Icons.Filled.Menu,
            info = "@shalatan.heif"
        )
        ContactInformation(
            icon = Icons.Filled.Menu,
            info = "shashanksingh6688@gmail.com"
        )
    }
}

@Composable
fun ContactInformation(icon: ImageVector, info: String) {
    Row(modifier = Modifier.padding(4.dp)) {
        Icon(imageVector = icon, contentDescription = null)
        Text(text = info, modifier = Modifier.padding(start = 8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    MyApplicationTheme {
        BusinessCardScreen()
    }
}