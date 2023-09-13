package com.example.movieappandroid.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.movieappandroid.domain.model.Movie

@Composable
fun MovieCard(movie: Movie, modifier: Modifier = Modifier) {

    var sizeImage by remember { mutableStateOf(IntSize.Zero) }
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color.Black),
        startY = sizeImage.height.toFloat() / 2,
        endY = sizeImage.height.toFloat()
    )
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        AsyncImage(
            model = movie.poster,
            contentDescription = null,
            modifier = Modifier.onGloballyPositioned {
                sizeImage = it.size
            }
        )
        Box(modifier = Modifier
            .matchParentSize()
            .background(gradient))
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp)
        ) {
            Text(
                text = movie.releaseDate.substring(0, 4),
                style = MaterialTheme.typography.labelMedium,
                color = Color.White
            )
            Text(
                modifier = Modifier,
                text = movie.title,
                style = MaterialTheme.typography.labelLarge,
                color = Color.White
            )
        }

        Column(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.TopEnd),
        ) {
            MovieAverage(movie.voteAverage.toString())
        }
    }
}

/*@Composable
@Preview
fun MovieCardPreview() {
    val movie = Movie(
        id = "615656",
        title = "Meg 2: The Trench",
        overview = "An exploratory dive into the deepest depths of the ocean of a daring research team spirals into chaos when a malevolent mining operation threatens their mission and forces them into a high-stakes battle for survival.",
        releaseDate = "2023-08-02",
        voteAverage = 6.9,
        poster = "https://loremflickr.com/400/400/cat?lock=1",
        popularity = 10.9
    )
    Surface(color = MaterialTheme.colorScheme.surface) {
        MovieCard(
            movie = movie, modifier = Modifier
                .fillMaxSize()
        )
    }
}*/

@Composable
fun MovieAverage(voteAverage: String) {
    val integerValue = voteAverage.substring(0, 1)
    val decimalValue = voteAverage.substring(1)
    Box(
        modifier = Modifier
            .size(28.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(MaterialTheme.colorScheme.onBackground, Color.Magenta)
                ), shape = CircleShape
            )
            .padding(2.dp), contentAlignment = Alignment.Center
    ) {
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(color = Color.White, fontWeight = FontWeight.Bold)
                ) {
                    append(integerValue)
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Normal,
                        fontSize = 8.sp,
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append(decimalValue)
                }
            }
        )
    }
}