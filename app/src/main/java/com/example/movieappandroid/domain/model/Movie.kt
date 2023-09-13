package com.example.movieappandroid.domain.model
data class Movie(
    val id: String,
    val title: String,
    val popularity: Double,
    val overview: String,
    val voteAverage: Double,
    val poster: String,
    val releaseDate: String,
    val expirationDate: Long
)
