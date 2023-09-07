package com.example.movieappandroid.data.repository.remote

import com.example.movieappandroid.domain.model.Movie

interface RemoteDataSource {

    suspend fun getDiscoverMovies(): List<Movie>?
}