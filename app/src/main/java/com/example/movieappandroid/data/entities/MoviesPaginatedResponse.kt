package com.example.movieappandroid.data.entities

import com.squareup.moshi.Json

class MoviesPaginatedResponse<T : Any?>(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val results: T? = null,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)
