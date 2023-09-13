package com.example.movieappandroid.data.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.movieappandroid.data.entities.local.MovieEntity
import com.example.movieappandroid.domain.model.Movie

@Dao
interface MoviesDao {

    @Upsert
    suspend fun upsertAll(movies: List<MovieEntity>?)

    @Query("SELECT * FROM movieentity")
    fun pagingSource(): PagingSource<Int,MovieEntity>
    @Query("DELETE FROM movieentity")
    suspend fun clear()
}