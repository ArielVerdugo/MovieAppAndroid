package com.example.movieappandroid.domain.usecase

import com.example.movieappandroid.domain.model.Details
import com.example.movieappandroid.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
interface GetDetailsUseCase {
    suspend operator fun invoke(movieId: Int): Flow<Details>
}

class GetDetailsUseCaseImpl @Inject constructor(
    private val detailRepository: MoviesRepository
) : GetDetailsUseCase {
    override suspend fun invoke(movieId: Int): Flow<Details> {
        val response = detailRepository.getDetailsMovie(movieId = movieId)
        return flow { emit(response) }
    }
}