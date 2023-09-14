package com.example.movieappandroid.data.entities.remote

import com.squareup.moshi.Json

class MoviesPaginatedResponse(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val results: List<MovieResponse>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)
