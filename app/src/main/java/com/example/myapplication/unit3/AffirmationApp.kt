package com.example.myapplication.unit3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.material3Theme.MyApplicationMaterial3Theme

//TODO completed: lazyColumn example
data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)

class Datasource {
    fun loadAffirmations(): List<Affirmation> {
        return listOf(
            Affirmation(R.string.affirmation1, R.drawable.affirm_1),
            Affirmation(R.string.affirmation2, R.drawable.affirm_2),
            Affirmation(R.string.affirmation3, R.drawable.affirm_3),
            Affirmation(R.string.affirmation4, R.drawable.affirm_4),
            Affirmation(R.string.affirmation5, R.drawable.affirm_5),
            Affirmation(R.string.affirmation6, R.drawable.affirm_1),
            Affirmation(R.string.affirmation7, R.drawable.affirm_2),
            Affirmation(R.string.affirmation8, R.drawable.affirm_3),
            Affirmation(R.string.affirmation9, R.drawable.affirm_4),
            Affirmation(R.string.affirmation10, R.drawable.affirm_5)
        )
    }
}

class AffirmationApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationMaterial3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationScreen(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun AffirmationScreen(modifier: Modifier = Modifier) {
    AffirmationList(affirmations = Datasource().loadAffirmations(), modifier = modifier)
}

@Composable
fun AffirmationList(affirmations: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(affirmations) { affirmation ->
            AffirmationCard(
                affirmation = affirmation,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(16.dp),
        backgroundColor = colorResource(id = R.color.li_blue),
        modifier = modifier
    ) {
        Column(modifier = Modifier) {
            Image(
                painter = painterResource(id = affirmation.imageResourceId),
                contentDescription = stringResource(
                    id = affirmation.stringResourceId
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = affirmation.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview10() {
    MyApplicationMaterial3Theme {
        AffirmationScreen(modifier = Modifier)
    }
}