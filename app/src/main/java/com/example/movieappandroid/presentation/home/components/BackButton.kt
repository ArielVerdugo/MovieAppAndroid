package com.example.movieappandroid.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieappandroid.R
import com.example.movieappandroid.presentation.theme.MovieAppAndroidTheme

@Composable
fun BackButton(modifier: Modifier = Modifier, color: Color, onBackPressed: () -> Unit) {
    Row(modifier = modifier.clickable { onBackPressed() }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_checvron), contentDescription = null, tint = color
        )
        Text(
            text = stringResource(R.string.back), style = MaterialTheme.typography.bodyLarge, color = color
        )
    }
}

@Composable
@Preview
fun BackButtonPreview() {
    MovieAppAndroidTheme {
        BackButton(color = Color.White) {}
    }
}