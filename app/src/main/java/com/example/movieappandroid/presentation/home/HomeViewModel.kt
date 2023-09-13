package com.example.movieappandroid.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.movieappandroid.data.entities.local.MovieEntity
import com.example.movieappandroid.data.entities.mapToMovieModel
import com.example.movieappandroid.domain.model.Movie
import com.example.movieappandroid.domain.usecase.GetDiscoverMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    pager: Pager<Int,MovieEntity>
) : ViewModel() {

    val moviesFlow = pager
        .flow
        .map {
            pagingData -> pagingData.map { it.mapToMovieModel() }
        }
        .cachedIn(viewModelScope)

    /*init {
        viewModelScope.launch {
            getDiscoverMovies()
        }
    }

    private suspend fun getDiscoverMovies() {
        viewModelScope.launch {
            val response = discoverMoviesUseCase.invoke()
            response.collect {
                _moviesState.value = it
            }
        }
    }*/
}