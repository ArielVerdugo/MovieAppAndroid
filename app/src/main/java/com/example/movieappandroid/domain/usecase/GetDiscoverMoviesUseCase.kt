package com.example.movieappandroid.domain.usecase

import androidx.paging.PagingData
import com.example.movieappandroid.domain.model.Movie
import com.example.movieappandroid.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetDiscoverMoviesUseCase {
    suspend operator fun invoke(): Flow<PagingData<Movie>>
}

class GetDiscoverMoviesUserCaseImpl @Inject constructor(
    private val moviesRepository: MoviesRepository
) : GetDiscoverMoviesUseCase {
    override suspend operator fun invoke(): Flow<PagingData<Movie>> {
        return moviesRepository.getDiscoverMovies()
    }
}