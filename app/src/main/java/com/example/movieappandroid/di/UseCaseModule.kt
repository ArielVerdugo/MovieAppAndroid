package com.example.movieappandroid.di

import com.example.movieappandroid.domain.usecase.GetDetailsUseCase
import com.example.movieappandroid.domain.usecase.GetDetailsUseCaseImpl
import com.example.movieappandroid.domain.usecase.GetDiscoverMoviesUseCase
import com.example.movieappandroid.domain.usecase.GetDiscoverMoviesUserCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class UseCaseModule {

    @Binds
    abstract fun bindDiscoverMoviesUseCase(getDiscoverMoviesUserCaseImpl: GetDiscoverMoviesUserCaseImpl): GetDiscoverMoviesUseCase

    @Binds
    abstract fun bindDetailsUseCase(getDetailUseCaseImpl: GetDetailsUseCaseImpl): GetDetailsUseCase
}