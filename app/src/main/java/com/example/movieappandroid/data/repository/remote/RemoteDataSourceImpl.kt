package com.example.movieappandroid.data.repository.remote

import com.example.movieappandroid.data.api.movies.MoviesService
import com.example.movieappandroid.domain.model.Movie
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val moviesService: MoviesService
) : RemoteDataSource {

    override suspend fun getDiscoverMovies(): List<Movie>? {
        val response = moviesService.discoverMovies()
        return response.body()?.results?.map { it.toDomain() }
    }
}