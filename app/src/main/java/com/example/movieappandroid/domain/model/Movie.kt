package com.example.movieappandroid.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey val id: String,
    val title: String,
    val popularity: Double,
    val overview: String,
    val voteAverage: Double,
    val poster: String,
    val releaseDate: String,
    val expirationDate: Long
)
