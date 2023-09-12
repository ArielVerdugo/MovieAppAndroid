package com.example.movieappandroid.di

import android.content.Context
import androidx.room.Room
import com.example.movieappandroid.data.db.MoviesDB
import com.example.movieappandroid.data.db.MoviesDao
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(@ApplicationContext context: Context): MoviesDB =
        Room
            .databaseBuilder(context, MoviesDB::class.java, "movies_database")
            .build()



}