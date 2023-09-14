package com.example.movieappandroid.presentation.home

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.movieappandroid.R
import com.example.movieappandroid.data.entities.mapToMovieModel
import com.example.movieappandroid.presentation.home.components.MovieCard
import com.example.movieappandroid.util.Constants.Companion.CELLS

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val viewModel: HomeViewModel = hiltViewModel()
    val movies = viewModel.getPopularMovies().collectAsLazyPagingItems()

    /*LaunchedEffect(key1 = movies.loadState) {
        if (movies.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: " + (movies.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }*/

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (movies.loadState.refresh is LoadState.Loading) {
            PageLoader(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(CELLS),
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
                items(movies.itemCount) { it ->
                    movies[it]?.let { it1 ->
                        MovieCard(
                            it1.mapToMovieModel()
                        )
                    }
                }
                item {
                    if (movies.loadState.append is LoadState.Loading) {
                        //LoadingNextPageItem(modifier = Modifier)
                    }
                }
            }
        }
    }
}