package com.example.movieappandroid.data.repository.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.movieappandroid.data.api.movies.MoviesService
import com.example.movieappandroid.data.db.MoviesDB
import com.example.movieappandroid.domain.model.Movie

@OptIn(ExperimentalPagingApi::class)
class MoviesRemoteMediator(
    private val moviesService: MoviesService,
    private val moviesDB: MoviesDB
) : RemoteMediator<Int, Movie>() {
    override suspend fun load(loadType: LoadType, state: PagingState<Int, Movie>): MediatorResult {
        val page: Int = when (loadType) {
            //First time load data
            LoadType.REFRESH -> {
                //...
            }
            //Load data at the end
            LoadType.PREPEND -> {
                //...
            }
            //Load data previously loaded
            LoadType.APPEND -> {
                //...
            }
        }
    }
}