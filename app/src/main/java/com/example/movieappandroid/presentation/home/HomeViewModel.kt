package com.example.movieappandroid.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.movieappandroid.domain.model.Movie
import com.example.movieappandroid.domain.usecase.GetDiscoverMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val discoverMoviesUseCase: GetDiscoverMoviesUseCase
) : ViewModel() {

    private val _moviesState: MutableStateFlow<PagingData<Movie>> =
        MutableStateFlow(value = PagingData.empty())
    val moviesState: MutableStateFlow<PagingData<Movie>> get() = _moviesState


    init {
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
    }
}