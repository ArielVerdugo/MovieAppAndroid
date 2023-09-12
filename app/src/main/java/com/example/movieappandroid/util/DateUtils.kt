package com.example.movieappandroid.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DateUtils {
    private const val FORMAT = "yyyy-MM-dd"

    fun LocalDate.parseToString():String {
        val formatter = DateTimeFormatter.ofPattern(FORMAT)
        return this.format(formatter)
    }

    fun String.fromBackendDateToLocalDate(): LocalDate? {
        return LocalDate.parse(this)
    }
}