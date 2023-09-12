package com.example.movieappandroid.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movieappandroid.R
import com.example.movieappandroid.domain.model.Movie
import com.example.movieappandroid.presentation.home.components.MovieCard
import com.example.movieappandroid.util.Resource

@Composable
fun HomeScreen() {

    val viewModel: HomeViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is Resource.Loading -> {

        }

        is Resource.Error -> {

        }

        is Resource.Success -> {
            MoviesList((uiState as Resource.Success).movies)
        }
    }
}

@Composable
fun MoviesList(movies: List<Movie>) {
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item(span = {
                GridItemSpan(maxCurrentLineSpan)
            }, content = {
                Text(
                    text = context.getString(R.string.movies_title),
                    style = MaterialTheme.typography.titleLarge
                )
            })
            items(items = movies, key = { movie -> movie.id }) { it ->
                MovieCard(
                    it
                )
            }
        }
    }
}