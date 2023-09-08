package com.example.movieappandroid.data.entities

import com.example.movieappandroid.domain.model.Movie
import com.squareup.moshi.Json

data class MovieResponse(
    @Json(name = "adult")
    val adult: Boolean? = null,
    @Json(name = "backdrop_path")
    val backdropPath: String? = null,
    @Json(name = "genre_ids")
    val genreIds: List<Int>?,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "original_language")
    val originalLanguage: String,
    @Json(name = "original_title")
    val originalTitle: String,
    @Json(name = "overview")
    val overview: String? = null,
    @Json(name = "popularity")
    val popularity: Double? = null,
    @Json(name = "poster_path")
    val posterPath: String,
    @Json(name = "release_date")
    val releaseDate: String,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "video")
    val video: Boolean? = null,
    @Json(name = "vote_average")
    val voteAverage: Double? = null,
    @Json(name = "vote_count")
    val voteCount: Int? = null
){
    fun toDomain(): Movie = Movie(
        id = this.id.toString() ?: "",
        title = this.title ?: "",
        popularity = this.popularity ?: 0.0,
        overview = this.overview ?: "",
        voteAverage = this.voteAverage ?: 0.0,
        poster = POSTER_BASE_URL + this.posterPath ?: "",
        releaseDate = this.releaseDate ?: ""
    )
}

const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w200"
