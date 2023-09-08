package com.example.movieappandroid.util

import com.example.movieappandroid.domain.model.Movie

sealed class Resource() {
    object Loading: Resource()
    data class Success(val movies: List<Movie>): Resource()
    data class Error(val message: String?) : Resource()
}