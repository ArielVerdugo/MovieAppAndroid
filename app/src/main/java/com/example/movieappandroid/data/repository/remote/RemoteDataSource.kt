package com.example.movieappandroid.data.repository.remote

import com.example.movieappandroid.data.entities.MovieResponse
import com.example.movieappandroid.data.entities.MoviesPaginatedResponse
import com.example.movieappandroid.domain.model.Details

interface RemoteDataSource {

    suspend fun getDiscoverMovies(pageNumber: Int): MoviesPaginatedResponse<List<MovieResponse>>

    suspend fun getMovieDetails(movieId: Int): Details
}