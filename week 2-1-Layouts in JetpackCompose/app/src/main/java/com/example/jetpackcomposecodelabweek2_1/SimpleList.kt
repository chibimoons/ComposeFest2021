package com.example.jetpackcomposecodelabweek2_1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.jetpackcomposecodelabweek2_1.ui.theme.JetpackComposeCodelabWeek2_1Theme
import kotlinx.coroutines.launch

@Composable
fun SimpleList() {
    Column {
        repeat(100) {
            Text("Item #$it")
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun SimpleListPreview() {
    JetpackComposeCodelabWeek2_1Theme {
        SimpleList()
    }
}

@Composable
fun LazyList() {
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        items(100) {
            Text("Item #$it")
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun LazyListPreview() {
    JetpackComposeCodelabWeek2_1Theme {
        LazyList()
    }
}

@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text("Item #$index", style = typography.subtitle1)

    }
}

@Composable
fun ImageList() {
    val scrollState = rememberLazyListState()
    LazyColumn(state = scrollState) {
        items(100) {
            ImageListItem(it)
        }
    }
}

@Preview
@Composable
fun ImageListPreview() {
    JetpackComposeCodelabWeek2_1Theme {
        ImageList()
    }
}

@Composable
fun ScrollingList() {
    val listSize = 100
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            Button(onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(0)
                }
            }) {
                Text("Scroll to the top")
            }
            Button(onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(listSize - 1)
                }
            }) {
                Text("Scroll to the bottom")
            }
        }
        
        LazyColumn(state = scrollState) {
            items(listSize) {
                ImageListItem(index = it)
            }
        }
    }
}

@Preview
@Composable
fun ScrollingListPreview() {
    JetpackComposeCodelabWeek2_1Theme {
        ScrollingList()
    }
}
