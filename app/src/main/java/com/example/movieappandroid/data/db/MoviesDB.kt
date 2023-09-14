package com.example.movieappandroid.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieappandroid.data.entities.local.MovieEntity
import com.example.movieappandroid.data.entities.local.RemoteKeysEntity

@Database(
    entities = [MovieEntity::class, RemoteKeysEntity::class],
    version = 1,
)
abstract class MoviesDB : RoomDatabase() {
    abstract val moviesDao: MoviesDao
    abstract val remoteKeysDao: RemoteKeysDao
}