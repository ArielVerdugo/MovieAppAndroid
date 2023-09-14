package com.example.movieappandroid.data.api.movies

import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetails {

    @GET("movie/{movieId}")
    suspend fun getMovieDetails(
        @Path("movieId") movieId: Int
    ): ApiDetailsMovie
}