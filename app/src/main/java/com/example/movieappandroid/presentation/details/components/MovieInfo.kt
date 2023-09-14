package com.example.movieappandroid.presentation.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieappandroid.R

@Composable
fun MovieInfo(movieTitle: String, moviePoster: String){
    Box(
        modifier = Modifier.background(Color.White)
    ) {
        AsyncImage(
            model = moviePoster,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Box (modifier = Modifier
            .align(Alignment.BottomEnd)){
            Text(text = movieTitle)
        }
    }
}


@Preview
@Composable
fun movieInfoPreview(){
    Box(
        modifier = Modifier.background(Color.White)
    ) {
        Image(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = null )
        Image(
            imageVector = Icons.Filled.PlayArrow,
            contentDescription = null,
            colorFilter = ColorFilter.tint(colorResource(id = R.color.black)),
            modifier = Modifier
                .align(Alignment.Center)
                .size(32.dp)
        )
        Box (modifier = Modifier
            .align(Alignment.BottomEnd)){
            Text(text = "Justice League")
        }
    }
}