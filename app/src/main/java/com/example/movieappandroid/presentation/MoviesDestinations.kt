package com.example.movieappandroid.presentation

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface MoviesDestination {
    val route: String
}

object HomeDestination : MoviesDestination {
    override val route = "home"
}

object DetailsDestination : MoviesDestination {
    override val route: String = "movie_details"
    const val movieId = "movie_id"
    val arguments = listOf(navArgument(movieId) { type = NavType.IntType })
    val routeWithArgs = "$route/{$movieId}"
}