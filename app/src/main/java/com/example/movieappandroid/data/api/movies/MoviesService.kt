package com.example.movieappandroid.data.api.movies

import com.example.movieappandroid.data.api.ApiConstants
import com.example.movieappandroid.data.entities.remote.MovieResponse
import com.example.movieappandroid.data.entities.remote.MoviesPaginatedResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {
    @GET(ApiConstants.URL_GET_DISCOVER_MOVIES)
    suspend fun discoverMovies(@Query("page") pageNumber: Int): MoviesPaginatedResponse<List<MovieResponse>>
}