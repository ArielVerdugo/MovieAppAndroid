package com.example.movieappandroid.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappandroid.domain.model.Movie
import com.example.movieappandroid.domain.usecase.GetDiscoverMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val discoverMoviesUseCase: GetDiscoverMoviesUseCase
): ViewModel() {

    lateinit var movies: Flow<List<Movie>>

    private val _isLoading = MutableStateFlow(true)
    val isLoading: Flow<Boolean> = _isLoading.asStateFlow()

    init {
        viewModelScope.launch{
            getDiscoverMovies()
        }
    }

    private suspend fun getDiscoverMovies(){
        viewModelScope.launch {
            _isLoading.value = true
            try {
                movies = discoverMoviesUseCase.invoke()
            }catch (e:Exception){
                Log.e("error",e.message.toString())
            }
            _isLoading.value = false
        }
    }
}