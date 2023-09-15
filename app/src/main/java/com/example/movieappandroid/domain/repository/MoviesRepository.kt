package com.example.movieappandroid.domain.repository

import androidx.paging.PagingData
import com.example.movieappandroid.domain.model.Details
import com.example.movieappandroid.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    suspend fun getDiscoverMovies(): Flow<PagingData<Movie>>
    suspend fun getDetailsMovie(movieId: Int): Details
}