package com.example.movieappandroid.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieappandroid.data.entities.local.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = 1,
)
abstract class MoviesDB : RoomDatabase() {
    abstract val dao: MoviesDao
}