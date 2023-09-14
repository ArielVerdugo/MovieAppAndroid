package com.example.movieappandroid.data.entities.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class RemoteKeysEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "movie_id")
    val movieID: Int,
    val prevKey: Int?,
    val currentPage: Int,
    val nextKey: Int?,
    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis()
)