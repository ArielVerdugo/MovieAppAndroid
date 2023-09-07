package com.example.movieappandroid.domain.usecase

import com.example.movieappandroid.domain.model.Movie
import com.example.movieappandroid.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetDiscoverMoviesUseCase {
    suspend operator fun invoke(): Flow<List<Movie>>
}

class GetDiscoverMoviesUserCaseImpl @Inject constructor(
    private val moviesRepository: MoviesRepository
) : GetDiscoverMoviesUseCase {
    override suspend operator fun invoke(): Flow<List<Movie>> {
        val response = moviesRepository.getDiscoverMovies()!!
        return flow { emit(response) }
    }
}