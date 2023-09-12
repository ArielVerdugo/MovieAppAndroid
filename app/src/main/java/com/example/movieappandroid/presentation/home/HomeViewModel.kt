package com.example.movieappandroid.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappandroid.domain.usecase.GetDiscoverMoviesUseCase
import com.example.movieappandroid.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val discoverMoviesUseCase: GetDiscoverMoviesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<Resource>(Resource.Loading)
    val uiState: StateFlow<Resource> = _uiState


    init {
        viewModelScope.launch {
            getDiscoverMovies()
        }
    }

    private suspend fun getDiscoverMovies() {
        viewModelScope.launch {
            val response = discoverMoviesUseCase.invoke()
            response.collect{
                _uiState.value = Resource.Success(it)
            }
        }
    }
}