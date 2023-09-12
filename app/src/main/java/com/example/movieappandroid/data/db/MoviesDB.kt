package com.example.movieappandroid.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieappandroid.domain.model.Movie
import com.example.movieappandroid.util.Constants.Companion.DB_NAME

/*@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MoviesDB: RoomDatabase() {

    abstract val moviesDao: MoviesDao

    companion object {
        @Volatile
        private lateinit var MOVIESDBINSTANCE: MoviesDB

        fun getMoviesDatabase(context: Context): MoviesDB {
            synchronized(this) {
                if (!Companion::MOVIESDBINSTANCE.isInitialized) {
                    MOVIESDBINSTANCE = Room.databaseBuilder(
                        context.applicationContext, MoviesDB::class.java, DB_NAME
                    ).build()
                }
            }
            return MOVIESDBINSTANCE
        }
    }
}*/