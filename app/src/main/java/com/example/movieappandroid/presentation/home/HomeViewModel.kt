package com.example.movieappandroid.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.movieappandroid.data.api.movies.MoviesService
import com.example.movieappandroid.data.db.MoviesDB
import com.example.movieappandroid.data.entities.local.MovieEntity
import com.example.movieappandroid.data.entities.mapToMovieModel
import com.example.movieappandroid.data.repository.remote.MoviesRemoteMediator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val moviesApiService: MoviesService,
    private val moviesDatabase: MoviesDB,
) : ViewModel() {

    @OptIn(ExperimentalPagingApi::class)
    fun getPopularMovies(): Flow<PagingData<MovieEntity>> =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 10,
                initialLoadSize = 20,
            ),
            pagingSourceFactory = {
                moviesDatabase.moviesDao.pagingSource()
            },
            remoteMediator = MoviesRemoteMediator(
                moviesApiService,
                moviesDatabase,
            )
        ).flow
}