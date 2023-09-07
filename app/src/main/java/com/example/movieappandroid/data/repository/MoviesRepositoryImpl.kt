package com.example.movieappandroid.data.repository

import com.example.movieappandroid.data.repository.remote.RemoteDataSource
import com.example.movieappandroid.domain.model.Movie
import com.example.movieappandroid.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): MoviesRepository {

    override suspend fun getDiscoverMovies(): List<Movie>? =
        remoteDataSource.getDiscoverMovies()
}