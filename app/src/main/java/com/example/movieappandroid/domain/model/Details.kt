package com.example.movieappandroid.domain.model

data class Details(
    val originalLanguage: String,
    val video: Boolean,
    val title: String,
    val backdropPath: String,
    val revenue: Long,
    val genres: List<Gender>,
    val popularity: Int,
    val id: Int,
    val voteCount: Int,
    val overview: String,
    val originalTitle: String,
    val posterPath: String,
    val voteAverage: Float,
    val status: String
)
