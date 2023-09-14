package com.example.movieappandroid.data.repository.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.movieappandroid.data.api.movies.MoviesService
import com.example.movieappandroid.data.db.MoviesDB
import com.example.movieappandroid.data.entities.local.MovieEntity
import com.example.movieappandroid.data.entities.local.RemoteKeysEntity
import com.example.movieappandroid.data.entities.mapFromListEntity
import com.example.movieappandroid.data.entities.mapToMovieEntity
import okio.IOException
import retrofit2.HttpException
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalPagingApi::class)
class MoviesRemoteMediator(
    private val moviesService: MoviesService,
    private val moviesDB: MoviesDB
) : RemoteMediator<Int, MovieEntity>() {

    override suspend fun initialize(): InitializeAction {
        val cacheTimeout = TimeUnit.MILLISECONDS.convert(24, TimeUnit.HOURS)
        return if (System.currentTimeMillis() - (moviesDB.remoteKeysDao.getCreationTime()
                ?: 0) < cacheTimeout
        ) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    private suspend fun getRemoteKeyClosestCurrentPosition(state: PagingState<Int, MovieEntity>): RemoteKeysEntity? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                moviesDB.remoteKeysDao.getRemoteKeyByMovieID(id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, MovieEntity>): RemoteKeysEntity? {
        return state.pages.firstOrNull {
            it.data.isNotEmpty()
        }?.data?.firstOrNull()?.let { movie ->
            moviesDB.remoteKeysDao.getRemoteKeyByMovieID(movie.id)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, MovieEntity>): RemoteKeysEntity? {
        return state.pages.lastOrNull {
            it.data.isNotEmpty()
        }?.data?.lastOrNull()?.let { movie ->
            moviesDB.remoteKeysDao.getRemoteKeyByMovieID(movie.id)
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, MovieEntity>
    ): MediatorResult {
        val page = when (loadType) {
            //First time load data
            LoadType.REFRESH -> {
                val remoteKeys = getRemoteKeyClosestCurrentPosition(state)
                remoteKeys?.nextKey?.minus(1) ?: 1
            }
            //Load data previously loaded
            LoadType.PREPEND -> {
                val remoteKeys = getRemoteKeyForFirstItem(state)
                val prevKey = remoteKeys?.prevKey
                prevKey
                    ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
            }
            //Load data at the end
            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                val nextKey = remoteKeys?.nextKey
                nextKey
                    ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
            }
        }
        try {
            val apiResponse = moviesService.discoverMovies(pageNumber = page).results
            val movies = apiResponse.mapFromListEntity()
            val endOfPaginationReached = movies.isEmpty()

            moviesDB.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    moviesDB.moviesDao.clear()
                    moviesDB.remoteKeysDao.clearRemoteKeys()
                }
                val prevKey = if (page > 1) page - 1 else null
                val nextKey = if (endOfPaginationReached) null else page + 1
                val remoteKeys = movies.map {
                    RemoteKeysEntity(
                        movieID = it.id,
                        prevKey = prevKey,
                        currentPage = page,
                        nextKey = nextKey
                    )
                }
                moviesDB.remoteKeysDao.insertAll(remoteKeys)
                /*val movesEntity = movies?.let { it -> it.map { it.mapToMovieEntity() } }
                moviesDB.moviesDao.upsertAll(movesEntity)*/
                moviesDB.moviesDao.upsertAll(movies.onEachIndexed { _, movie -> movie.page = page })

            }
            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (error: IOException) {
            return MediatorResult.Error(error)
        } catch (error: HttpException) {
            return MediatorResult.Error(error)
        }
    }
}