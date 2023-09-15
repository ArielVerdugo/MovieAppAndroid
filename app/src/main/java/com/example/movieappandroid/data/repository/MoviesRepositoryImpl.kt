package com.example.movieappandroid.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.movieappandroid.data.repository.remote.MoviePagingSource
import com.example.movieappandroid.data.repository.remote.RemoteDataSource
import com.example.movieappandroid.domain.model.Details
import com.example.movieappandroid.domain.model.Movie
import com.example.movieappandroid.domain.repository.MoviesRepository
import com.example.movieappandroid.util.Constants.Companion.PAGE_SIZE
import com.example.movieappandroid.util.Constants.Companion.PREFETCH_DISTANCE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : MoviesRepository {

    override suspend fun getDiscoverMovies(): Flow<PagingData<Movie>> =
        Pager(
            config = PagingConfig(pageSize = PAGE_SIZE, prefetchDistance = PREFETCH_DISTANCE),
            pagingSourceFactory = {
                MoviePagingSource(remoteDataSource = remoteDataSource)
            }
        ).flow

    override suspend fun getDetailsMovie(movieId: Int): Details {
        return remoteDataSource.getMovieDetails(movieId)
    }
}