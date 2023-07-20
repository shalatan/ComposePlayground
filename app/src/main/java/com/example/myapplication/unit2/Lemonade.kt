package com.example.myapplication.unit2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.material3Theme.MyApplicationMaterial3Theme

class Lemonade : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationMaterial3Theme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeScreen(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun LemonadeScreen(modifier: Modifier = Modifier) {
    var stage by remember { mutableIntStateOf(1) }
    var taps by remember { mutableIntStateOf(0) }
    when (stage) {
        1 -> LemonadeCard(
            picture = R.drawable.lemon_tree,
            message = stringResource(id = R.string.lemon_tree),
            onImageClick = {
                stage = 2
                taps = (4..8).random()
            }, modifier = modifier
        )

        2 -> LemonadeCard(
            picture = R.drawable.lemon_squeeze,
            message = stringResource(id = R.string.lemon_squeeze),
            onImageClick = {
                taps--
                if (taps == 0) {
                    stage = 3
                }
            })

        3 -> LemonadeCard(
            picture = R.drawable.lemon_drink,
            message = stringResource(id = R.string.lemon_drink),
            onImageClick = { stage = 4 })

        4 -> LemonadeCard(
            picture = R.drawable.lemon_restart,
            message = stringResource(id = R.string.lemon_restart),
            onImageClick = { stage = 1 })
    }
}

@Composable
fun LemonadeCard(
    picture: Int,
    message: String,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onImageClick,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
        ) {
            Image(
                painter = painterResource(id = picture),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    MyApplicationMaterial3Theme() {
        LemonadeScreen(modifier = Modifier)
    }
}