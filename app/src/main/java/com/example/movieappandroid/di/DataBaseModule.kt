package com.example.movieappandroid.di

import android.content.Context
import androidx.room.Room
import com.example.movieappandroid.data.db.MoviesDB
import com.example.movieappandroid.data.db.MoviesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(@ApplicationContext context: Context): MoviesDB =
        Room
            .databaseBuilder(context, MoviesDB::class.java, "movies_database")
            .build()

    @Singleton
    @Provides
    fun provideMoviesDao(moviesDatabase: MoviesDB): MoviesDao = moviesDatabase.getMoviesDao()
}