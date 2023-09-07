package com.example.movieappandroid.data.api

import okhttp3.Headers
import okhttp3.Headers.Companion.toHeaders

object HeadersBuilder {
    private const val AUTHORIZATION_HEADER = "Authorization"

    fun getCommonHeaders(): Headers {
        val headers = HashMap<String, String>()
        val accessToken =
            "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxZDFlM2ViMzRkNzBkMTIwZDQzOTU0Y2Q4MWY1OTE1ZCIsInN1YiI6IjYzNjUxNzExNTQzN2Y1MDA3ZjJmOTEyNiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Mghe0tevEBk7pDlYo71gsXB5zxNrspYW7xMWdbLVCNw"
        headers[AUTHORIZATION_HEADER] = accessToken
        return headers.toHeaders()
    }
}