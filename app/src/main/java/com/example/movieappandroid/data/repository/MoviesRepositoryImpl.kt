package com.example.movieappandroid.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.movieappandroid.data.repository.remote.MoviePagingSource
import com.example.movieappandroid.data.repository.remote.RemoteDataSource
import com.example.movieappandroid.domain.model.Movie
import com.example.movieappandroid.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : MoviesRepository {

    override suspend fun getDiscoverMovies(): Flow<PagingData<Movie>> =
        Pager(
            config = PagingConfig(pageSize = 14, prefetchDistance = 2),
            pagingSourceFactory = {
                MoviePagingSource(remoteDataSource = remoteDataSource)
            }
        ).flow
}