package com.example.movieappandroid.data.entities

import com.example.movieappandroid.domain.model.Movie
import com.example.movieappandroid.util.Constants.Companion.POSTER_BASE_URL

fun MovieResponse.mapFromEntity() = Movie(
    id = this.id.toString(),
    overview = this.overview.orEmpty(),
    popularity = this.popularity ?: 0.0,
    poster =  POSTER_BASE_URL + this.posterPath ?: "",
    releaseDate = this.releaseDate.orEmpty(),
    title = this.title.orEmpty(),
    voteAverage = this.voteAverage ?: 0.0,
    expirationDate = System.currentTimeMillis()
)

fun List<MovieResponse>.mapFromListModel(): List<Movie> {
    return this.map {
        it.mapFromEntity()
    }
}