package com.example.movieappandroid.data.entities

import com.squareup.moshi.Json

data class GenderResponse(
    @Json(name = "name")
    val name: String = "",
    @Json(name = "id")
    val id: Int = 0
)

