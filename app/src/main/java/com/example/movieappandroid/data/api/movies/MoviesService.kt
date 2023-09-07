package com.example.movieappandroid.data.api.movies

import com.example.movieappandroid.data.api.ApiConstants
import com.example.movieappandroid.data.entities.MovieResponse
import com.example.movieappandroid.data.entities.MoviesPaginatedResponse
import retrofit2.Response
import retrofit2.http.GET

interface MoviesService {
    @GET(ApiConstants.URL_GET_DISCOVER_MOVIES)
    suspend fun discoverMovies(): Response<MoviesPaginatedResponse<MovieResponse>>
}