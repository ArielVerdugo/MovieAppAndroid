package com.example.movieappandroid.presentation.theme

import android.provider.CalendarContract
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColors(
    var extraColorOrange: Color = Color.Unspecified
)

val LightExtraColorOrange = Color(0xFFF37A54)

val DarkExtraColorOrange = Color(0xE9F37A54)

val LightCustomColorsPalette = CustomColors(
    extraColorOrange = LightExtraColorOrange
)

val DarkCustomColorsPalette = CustomColors(
    extraColorOrange = DarkExtraColorOrange
)

val LocalCustomColorsPalette = staticCompositionLocalOf { CustomColors() }