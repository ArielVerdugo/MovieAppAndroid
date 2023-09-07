package com.example.movieappandroid.di

import android.content.Context
import androidx.room.Room
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

class DataBaseModule {

    /*@Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): MovieAppDatabase {
        return Room.databaseBuilder(
            appContext,
            MovieAppDatabase::class.java,
            "boilerplate_database.db"
        ).build()
    }

    @Provides
    fun provideLogDao(database: MovieAppDatabase): MovieDao {
        return database.productDao
    }*/
}