package com.example.movieappandroid.presentation.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.ceil
import kotlin.math.floor


@Composable
fun MovieDetails(gender: String, votes: Int, popularity: Int){
    Box(modifier = Modifier.fillMaxSize()){
        Row() {
            Text(text = "3,292")
            Text(text = "People wathing")
        }
    }
}

@Preview
@Composable
fun MovieDetails(){
    val voteAverage = "9.8"
    val integerValue = voteAverage.substring(0, 1)
    val decimalValue = voteAverage.substring(1)
    Box(
        modifier = Modifier
            .background(Color.White)
    ){
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Row(
            ) {
                Text(text = "3,292")
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "People wathing"
                )
            }
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = "Action,Adventure,Fantasy"
            )
            Row(
                modifier = Modifier.padding(top = 10.dp)
            ) {
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold)
                        ) {
                            append(integerValue)
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Red,
                                fontWeight = FontWeight.Normal,
                                fontSize = 8.sp,
                                baselineShift = BaselineShift.Superscript
                            )
                        ) {
                            append(decimalValue)
                        }
                    }
                )
                RatingBar(
                )
            }
        }

    }
}

@Preview
@Composable
fun RatingBar(

) {
    var modifier: Modifier = Modifier
    var rating: Double = 3.0
    var stars: Int = 5
    var starsColor: Color = Color.Red
    val filledStars = floor(rating).toInt()
    val unfilledStars = (stars - ceil(rating)).toInt()
    val halfStar = !(rating.rem(1).equals(0.0))
    Row(modifier = modifier) {
        repeat(filledStars) {
            Icon(imageVector = Icons.Outlined.Star, contentDescription = null, tint = starsColor)
        }
        if (halfStar) {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null,
                tint = starsColor
            )
        }
        repeat(unfilledStars) {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null,
                tint = starsColor
            )
        }
    }
}