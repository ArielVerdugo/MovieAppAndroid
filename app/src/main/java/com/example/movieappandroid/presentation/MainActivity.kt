package com.example.movieappandroid.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieappandroid.presentation.details.DetailScreen
import com.example.movieappandroid.presentation.home.HomeScreen
import com.example.movieappandroid.presentation.theme.MovieAppAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MoviesNavHost()
                }
            }
        }
    }
}

@Composable
fun MoviesNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = HomeDestination.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(startDestination) {
            HomeScreen(
                onMoviePressed = {
                    navController.navigateToDetails(it.id.toInt())
                }
            )
        }
        composable(route = DetailsDestination.routeWithArgs, arguments = DetailsDestination.arguments) { _ ->
            DetailScreen()
        }
    }
}

private fun NavHostController.navigateToDetails(movieId: Int) {
    this.navigate("${DetailsDestination.route}/$movieId")
}