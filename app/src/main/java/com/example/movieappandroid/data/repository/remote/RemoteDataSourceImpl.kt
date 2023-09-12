package com.example.movieappandroid.data.repository.remote

import com.example.movieappandroid.data.api.movies.MoviesService
import com.example.movieappandroid.data.entities.MovieResponse
import com.example.movieappandroid.data.entities.MoviesPaginatedResponse
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val moviesService: MoviesService
) : RemoteDataSource {

    override suspend fun getDiscoverMovies(pageNumber: Int): MoviesPaginatedResponse<List<MovieResponse>> {
        return moviesService.discoverMovies(pageNumber)
    }
}