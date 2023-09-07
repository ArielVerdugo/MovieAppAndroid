package com.example.movieappandroid.di

import com.example.movieappandroid.data.repository.MoviesRepositoryImpl
import com.example.movieappandroid.data.repository.remote.RemoteDataSource
import com.example.movieappandroid.data.repository.remote.RemoteDataSourceImpl
import com.example.movieappandroid.domain.repository.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class RepositoryModule {

    @ActivityRetainedScoped
    @Binds
    abstract fun provideMoviesRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MoviesRepository

    @Binds
    abstract fun provideRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

}