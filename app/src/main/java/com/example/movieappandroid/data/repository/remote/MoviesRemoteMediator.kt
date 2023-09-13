package com.example.movieappandroid.data.repository.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.movieappandroid.data.api.movies.MoviesService
import com.example.movieappandroid.data.db.MoviesDB
import com.example.movieappandroid.data.entities.local.MovieEntity
import com.example.movieappandroid.data.entities.mapToMovieEntity
import okio.IOException
import retrofit2.HttpException

@OptIn(ExperimentalPagingApi::class)
class MoviesRemoteMediator(
    private val moviesService: MoviesService,
    private val moviesDB: MoviesDB
) : RemoteMediator<Int, MovieEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, MovieEntity>
    ): MediatorResult {
        return try {
            val page = when (loadType) {
                //First time load data
                LoadType.REFRESH -> 1
                //Load data at the end
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                //Load data previously loaded
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        lastItem.id?.let {
                            (it / state.config.pageSize) + 1
                        }
                    }
                }
            }
            val movies = moviesService.discoverMovies(pageNumber = page!!).results
            moviesDB.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    moviesDB.dao.clear()
                }
                val movesEntity = movies?.let { it -> it.map { it.mapToMovieEntity() } }
                moviesDB.dao.upsertAll(movesEntity)
            }
            MediatorResult.Success(
                endOfPaginationReached = movies.isNullOrEmpty()
            )

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}