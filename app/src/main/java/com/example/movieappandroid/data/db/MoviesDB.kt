package com.example.movieappandroid.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieappandroid.domain.model.Movie
import com.example.movieappandroid.util.Constants.Companion.DB_NAME

@Database(
    entities = [Movie::class],
    version = 1,
)
abstract class MoviesDB : RoomDatabase() {
    abstract fun getMoviesDao(): MoviesDao
}