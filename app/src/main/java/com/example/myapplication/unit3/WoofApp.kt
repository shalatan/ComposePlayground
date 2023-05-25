package com.example.myapplication.unit3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.unit3.ui.theme.MyApplicationTheme

data class Dog(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val hobbies: Int
)

object DogsDataSource {
    val dogs = listOf(
        Dog(R.drawable.koda, R.string.dog_name_1, 2, R.string.dog_description_1),
        Dog(R.drawable.lola, R.string.dog_name_2, 16, R.string.dog_description_2),
        Dog(R.drawable.frankie, R.string.dog_name_3, 2, R.string.dog_description_3),
        Dog(R.drawable.nox, R.string.dog_name_4, 8, R.string.dog_description_4),
        Dog(R.drawable.faye, R.string.dog_name_5, 8, R.string.dog_description_5),
        Dog(R.drawable.bella, R.string.dog_name_6, 14, R.string.dog_description_6),
        Dog(R.drawable.moana, R.string.dog_name_7, 2, R.string.dog_description_7),
        Dog(R.drawable.tzeitel, R.string.dog_name_8, 7, R.string.dog_description_8),
        Dog(R.drawable.leroy, R.string.dog_name_9, 4, R.string.dog_description_9)
    )
}

class WoofApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WoofAppScreen()
                }
            }
        }
    }
}

@Composable
fun WoofAppScreen() {
    LazyColumn {
        items(DogsDataSource.dogs) {
            DogItem(
                dog = it,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun WoofTopAppBar(modifier: Modifier = Modifier) {

}

@Composable
fun DogItem(
    dog: Dog,
    modifier: Modifier = Modifier
) {
    //card by default uses medium shape, hence no need to explicitly set it
    //refer shapes.kt for overridden shapes
    Card(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_small))
        ) {
            DogIcon(dog.imageResourceId)
            DogInformation(dog.name, dog.age)
        }
    }
}

@Composable
fun DogIcon(
    @DrawableRes dogIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(64.dp)
            .padding(dimensionResource(id = R.dimen.padding_medium))
            .clip(MaterialTheme.shapes.small),
//            .clip(RoundedCornerShape(50.dp)),
        contentScale = ContentScale.Crop,
        painter = painterResource(dogIcon),
        contentDescription = null,
    )
}

@Composable
fun DogInformation(
    @StringRes dogName: Int,
    dogAge: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(dogName),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
        )
        Text(
            text = stringResource(R.string.years_old, dogAge),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyApplicationTheme {
        WoofAppScreen()
    }
}

//@Preview
@Composable
fun GreetingPreview2Dark() {
    MyApplicationTheme(darkTheme = true) {
        WoofAppScreen()
    }
}

