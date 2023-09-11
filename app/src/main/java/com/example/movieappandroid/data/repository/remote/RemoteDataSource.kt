package com.example.movieappandroid.data.repository.remote

import com.example.movieappandroid.data.entities.MovieResponse
import com.example.movieappandroid.data.entities.MoviesPaginatedResponse

interface RemoteDataSource {

    suspend fun getDiscoverMovies(pageNumber: Int): MoviesPaginatedResponse<List<MovieResponse>>
}