package com.example.movieappandroid.data.repository.remote

import com.example.movieappandroid.data.api.movies.MoviesService
import com.example.movieappandroid.data.entities.MovieResponse
import com.example.movieappandroid.data.entities.MoviesPaginatedResponse
import com.example.movieappandroid.data.entities.mapToEntity
import com.example.movieappandroid.domain.model.Details
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val moviesService: MoviesService
) : RemoteDataSource {

    override suspend fun getDiscoverMovies(pageNumber: Int): MoviesPaginatedResponse<List<MovieResponse>> {
        return moviesService.discoverMovies(pageNumber)
    }

    override suspend fun getMovieDetails(movieId: Int): Details {
        val response = moviesService.getMovieDetails(movieId = movieId)
        return response.mapToEntity()
    }
}