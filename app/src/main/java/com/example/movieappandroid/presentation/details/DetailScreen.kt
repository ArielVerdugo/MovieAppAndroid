package com.example.movieappandroid.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieappandroid.R
import com.example.movieappandroid.presentation.details.components.GradientFabPreview
import com.example.movieappandroid.presentation.details.components.MovieDetailsPreview
import com.example.movieappandroid.presentation.details.components.MovieInfoPreview

@Composable
fun DetailScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ){
        Column {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(1f)
            ) {
                //MovieInfo()
                Row(
                    modifier = Modifier.padding(start = 20.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.trace),
                        contentDescription = null,
                        modifier = Modifier
                            .height(200.dp)
                            .offset(y = -100.dp)
                    )
                    //MovieDetails()
                }
                Text(
                    "tu hermana",
                    modifier = Modifier
                        .offset(y = -60.dp)
                        .padding(start = 20.dp)
                )
                Row(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    GradientFabPreview()
                }
            }
        }

    }
}

@Preview
@Composable
fun DetailsScreenPreview(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ){
        Column {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(1f)
            ) {
                MovieInfoPreview()
                Row(
                    modifier = Modifier.padding(start = 20.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.trace),
                        contentDescription = null,
                        modifier = Modifier
                            .height(200.dp)
                            .offset(y = -100.dp)
                    )
                    MovieDetailsPreview()
                }
                Text(
                    "tu hermana",
                    modifier = Modifier
                        .offset(y = -80.dp)
                        .padding(start = 20.dp)
                )
                Row(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    GradientFabPreview()
                }
            }
        }

    }
}