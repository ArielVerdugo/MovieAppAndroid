package com.example.movieappandroid.data.api.movies

import com.example.movieappandroid.data.api.ApiConstants
import com.example.movieappandroid.data.entities.MovieDetailsResponse
import com.example.movieappandroid.data.entities.MovieResponse
import com.example.movieappandroid.data.entities.MoviesPaginatedResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {
    @GET(ApiConstants.URL_GET_DISCOVER_MOVIES)
    suspend fun discoverMovies(@Query("page") pageNumber: Int): MoviesPaginatedResponse<List<MovieResponse>>

    @GET(ApiConstants.URL_GET_DETAILS_MOVIES)
    suspend fun getMovieDetails(
        @Path("movieId") movieId: Int
    ): MovieDetailsResponse
}