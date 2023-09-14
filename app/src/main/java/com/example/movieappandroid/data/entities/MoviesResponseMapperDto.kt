package com.example.movieappandroid.data.entities

import com.example.movieappandroid.data.entities.local.MovieEntity
import com.example.movieappandroid.data.entities.remote.MovieResponse
import com.example.movieappandroid.domain.model.Movie
import com.example.movieappandroid.util.Constants.Companion.POSTER_BASE_URL
fun MovieResponse.mapToMovieEntity(): MovieEntity {
    return MovieEntity(
        id = this.id,
        overview = this.overview.orEmpty(),
        popularity = this.popularity ?: 0.0,
        posterPath =  POSTER_BASE_URL + this.posterPath ?: "",
        releaseDate = this.releaseDate.orEmpty(),
        title = this.title.orEmpty(),
        voteAverage = this.voteAverage ?: 0.0,
        expirationDate = System.currentTimeMillis(),
        page = 0
    )
}
fun MovieEntity.mapToMovieModel(): Movie{
    return Movie(
        id = this.id.toString(),
        overview = this.overview.orEmpty(),
        popularity = this.popularity ?: 0.0,
        poster =  POSTER_BASE_URL + this.posterPath ?: "",
        releaseDate = this.releaseDate.orEmpty(),
        title = this.title.orEmpty(),
        voteAverage = this.voteAverage ?: 0.0,
        expirationDate = System.currentTimeMillis()
    )
}

fun List<MovieResponse>.mapFromListEntity(): List<MovieEntity> {
    return this.map {
        it.mapToMovieEntity()
    }
}

fun List<MovieEntity>.mapFromListModel(): List<Movie> {
    return this.map {
        it.mapToMovieModel()
    }
}