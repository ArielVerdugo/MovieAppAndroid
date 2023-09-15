package com.example.movieappandroid.util

import com.example.movieappandroid.domain.model.Details

sealed class DetailResource(){
    object Loading: DetailResource()
    data class Success(val movies: Details): DetailResource()
    data class Error(val message: String?) : DetailResource()
}
