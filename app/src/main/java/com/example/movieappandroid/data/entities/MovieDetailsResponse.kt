package com.example.movieappandroid.data.entities

import com.squareup.moshi.Json

data class MovieDetailsResponse(
    @Json(name = "original_language")
    val originalLanguage: String,
    @Json(name = "imdb_id")
    val imdbId: String,
    @Json(name = "video")
    val video: Boolean,
    @Json(name = "title")
    val title: String,
    @Json(name = "backdrop_path")
    val backdropPath: String?,
    @Json(name = "revenue")
    val revenue: Long,
    @Json(name = "genres")
    val genres: List<Gender>,
    @Json(name = "popularity")
    val popularity: Float,
    @Json(name = "production_countries")
    val productionCountries: List<ProductionCountriesItem>?,
    @Json(name = "id")
    val id: Int,
    @Json(name = "vote_count")
    val voteCount: Int,
    @Json(name = "budget")
    val budget: Int,
    @Json(name = "overview")
    val overview: String,
    @Json(name = "original_title")
    val originalTitle: String,
    @Json(name = "runtime")
    val runtime: Int,
    @Json(name = "poster_path")
    val posterPath: String?,
    @Json(name = "release_date")
    val releaseDate: String,
    @Json(name = "vote_average")
    val voteAverage: Float,
    @Json(name = "belongs_to_collection")
    val belongsToCollection: BelongsToCollection?,
    @Json(name = "tagline")
    val tagline: String,
    @Json(name = "status")
    val status: String
)
