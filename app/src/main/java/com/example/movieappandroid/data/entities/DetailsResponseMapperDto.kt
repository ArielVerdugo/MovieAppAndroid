package com.example.movieappandroid.data.entities

import com.example.movieappandroid.domain.model.Details
import com.example.movieappandroid.domain.model.Gender
import com.example.movieappandroid.util.Constants.Companion.POSTER_BASE_URL

fun MovieDetailsResponse.mapToEntity() = Details(
    id = id,
    title = title,
    genres = genres.mapFromListModel(),
    overview = overview,
    voteAverage = voteAverage,
    popularity = popularity.toString().replace(".", "").toInt(),
    posterPath = POSTER_BASE_URL + posterPath,
    backdropPath = POSTER_BASE_URL + backdropPath,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    revenue = revenue,
    status = status,
    video = video,
    voteCount = voteCount
)

fun GenderResponse.mapToEntity() = Gender(
    name = name,
    id = id
)

fun List<GenderResponse>.mapFromListModel(): List<Gender> {
    return this.map {
        it.mapToEntity()
    }
}