package com.example.myapplication.unit3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.material3Theme.MyApplicationMaterial3Theme

data class Topic(
    @StringRes val name: Int,
    val point: Int,
    @DrawableRes val image: Int
)

object TopicDataSource {
    val topics = listOf(
        Topic(R.string.architecture, 58, R.drawable.topic_architecture),
        Topic(R.string.crafts, 121, R.drawable.topic_crafts),
        Topic(R.string.business, 78, R.drawable.topic_business),
        Topic(R.string.culinary, 118, R.drawable.topic_culinary),
        Topic(R.string.design, 423, R.drawable.topic_design),
        Topic(R.string.fashion, 92, R.drawable.topic_fashion),
        Topic(R.string.film, 165, R.drawable.topic_film),
        Topic(R.string.gaming, 164, R.drawable.topic_gaming),
        Topic(R.string.drawing, 326, R.drawable.topic_drawing),
        Topic(R.string.lifestyle, 305, R.drawable.topic_lifestyle),
        Topic(R.string.music, 212, R.drawable.topic_music),
        Topic(R.string.painting, 172, R.drawable.topic_painting),
        Topic(R.string.photography, 321, R.drawable.topic_photography),
        Topic(R.string.tech, 118, R.drawable.topic_tech)
    )
}

class TopicsApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationMaterial3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicsScreen()
                }
            }
        }
    }
}

@Composable
fun TopicsScreen() {
    TopicsRecyclerView(
        topics = TopicDataSource.topics,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun TopicsRecyclerView(topics: List<Topic>, modifier: Modifier = Modifier) {
    GridItemSpan(2)
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(topics) { topic ->
            TopicsCard(topic = topic, modifier = Modifier)
        }
    }
}

@Composable
fun TopicsCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = topic.image),
                contentDescription = stringResource(
                    id = topic.name
                ),
                modifier = Modifier.size(68.dp)
            )
            Column(
                modifier = Modifier.padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 4.dp
                )
            ) {
                Text(
                    text = stringResource(id = topic.name),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(
                    modifier = Modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null
                    )
                    Text(
                        text = topic.point.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationMaterial3Theme {
        TopicsScreen()
    }
}