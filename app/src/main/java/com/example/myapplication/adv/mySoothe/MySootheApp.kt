package com.example.myapplication.adv.mySoothe

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.adv.mySoothe.model.ImageWithText
import com.example.myapplication.ui.material3Theme.MyApplicationMaterial3Theme
import java.util.Locale

val highlights = listOf<ImageWithText>(
    ImageWithText(image = R.drawable.android_superhero1, text = "Robot"),
    ImageWithText(image = R.drawable.android_superhero2, text = "CatWoman"),
    ImageWithText(image = R.drawable.android_superhero3, text = "Flash"),
    ImageWithText(image = R.drawable.android_superhero4, text = "Batman"),
    ImageWithText(image = R.drawable.android_superhero5, text = "IceWhite"),
    ImageWithText(image = R.drawable.android_superhero6, text = "Curly")
)

@Preview(showBackground = true)
@Composable
fun MySootheAppPreview() {
    MyApplicationMaterial3Theme {
        MySootheApp()
    }
}

@Composable
fun MySootheApp(modifier: Modifier = Modifier) {
    Scaffold(bottomBar = { SootheBottomNavigation() }) { paddingValues ->
        HomeScreen(modifier = modifier.padding(paddingValues))
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(modifier = Modifier.padding(horizontal = 16.dp))
        HomeSection(title = "available superheroes") {
            AlignYourBodyRow(imageWithTexts = highlights)
        }
        HomeSection(title = "favourite collection") {
            FavoriteCollectionsGrid(imageWithTexts = highlights)
        }
    }
}

@Composable
fun HomeSection(
    title: String, modifier: Modifier = Modifier, content: @Composable () -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = title.toUpperCase(Locale.getDefault()),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(value = "", onValueChange = {}, leadingIcon = {
        Icon(imageVector = Icons.Default.Search, contentDescription = "search")
    }, placeholder = {
        Text(text = "Search..")
    }, modifier = modifier
        .fillMaxWidth()
        .heightIn(min = 56.dp)
    )
}

@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier, imageWithTexts: List<ImageWithText>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier.padding(vertical = 16.dp)
    ) {
        items(imageWithTexts) {
            AlignYourBodyElement(imageWithText = it)
        }
    }
}

@Composable
fun AlignYourBodyElement(imageWithText: ImageWithText, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageWithText.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = imageWithText.text,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.paddingFromBaseline(
                top = 32.dp, bottom = 8.dp
            )
        )
    }
}

@Composable
fun FavoriteCollectionsGrid(
    imageWithTexts: List<ImageWithText>, modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .height(136.dp)
            .padding(vertical = 8.dp)
    ) {
        items(imageWithTexts) { item ->
            FavoriteCollectionCard(
                item, modifier = Modifier.height(56.dp)
            )
        }
    }
}

@Composable
fun FavoriteCollectionCard(
    imageWithText: ImageWithText, modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small, modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.width(192.dp)
        ) {
            Image(
                painter = painterResource(imageWithText.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = imageWithText.text,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background, modifier = modifier
    ) {
        BottomNavigationItem(icon = {
            Icon(
                imageVector = Icons.Default.Spa, contentDescription = null
            )
        }, label = {
            Text("Home")
        }, selected = true, onClick = {})
        BottomNavigationItem(icon = {
            Icon(
                imageVector = Icons.Default.AccountCircle, contentDescription = null
            )
        }, label = {
            Text("Profile")
        }, selected = false, onClick = {})
    }
}