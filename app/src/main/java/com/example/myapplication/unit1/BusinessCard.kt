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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

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
    Box(modifier = Modifier.fillMaxSize()) {
        InfoCard(modifier = Modifier.align(Alignment.Center))
        ContactCard(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun InfoCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_task),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(80.dp)
        )
        Text(
            text = "Shashank Singh",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = "Android Developer",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 4.dp),
            color = Color(0xFF007E38)
        )
    }
}

@Composable
fun ContactCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp),
    ) {
        ContactInformation(
            icon = Icons.Filled.Phone,
            info = "+91 987543321",
        )
        ContactInformation(
            icon = Icons.Filled.Person,
            info = "@shalatan.heif"
        )
        ContactInformation(
            icon = Icons.Filled.Email,
            info = "shashanksingh6688@gmail.com"
        )
    }
}

@Composable
fun ContactInformation(icon: ImageVector, info: String) {
    Row(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = Color(0xFF007E38))
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