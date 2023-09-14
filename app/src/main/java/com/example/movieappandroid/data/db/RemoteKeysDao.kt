package com.example.movieappandroid.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieappandroid.data.entities.local.RemoteKeysEntity

@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKeys: List<RemoteKeysEntity>)

    @Query("Select * From remotekeysentity Where movie_id = :id")
    suspend fun getRemoteKeyByMovieID(id: Int): RemoteKeysEntity?

    @Query("Delete From remotekeysentity")
    suspend fun clearRemoteKeys()

    @Query("Select created_at From remotekeysentity Order By created_at Desc Limit 1")
    suspend fun getCreationTime(): Long?
}