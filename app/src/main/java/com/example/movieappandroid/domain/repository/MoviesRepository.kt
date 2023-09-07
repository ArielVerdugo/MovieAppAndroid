package com.example.movieappandroid.domain.repository

import com.example.movieappandroid.domain.model.Movie

interface MoviesRepository {

    suspend fun getDiscoverMovies(): List<Movie>?
}