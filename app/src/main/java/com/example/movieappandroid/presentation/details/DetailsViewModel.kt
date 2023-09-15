package com.example.movieappandroid.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappandroid.domain.usecase.GetDetailsUseCase
import com.example.movieappandroid.util.DetailResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val detailUseCase: GetDetailsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailResource>(DetailResource.Loading)
    val uiState: StateFlow<DetailResource> = _uiState

    private suspend fun getDetails(movieId: Int) {
        viewModelScope.launch {
            val response = detailUseCase.invoke(movieId)
            response.collect{
                _uiState.value = DetailResource.Success(it)
            }
        }
    }

}