package com.example.movieappandroid.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.example.movieappandroid.data.api.ApiConstants
import com.example.movieappandroid.data.api.HeadersInterceptor
import com.example.movieappandroid.data.api.movies.MoviesService
import com.example.movieappandroid.data.db.MoviesDB
import com.example.movieappandroid.data.entities.local.MovieEntity
import com.example.movieappandroid.data.repository.remote.MoviesRemoteMediator
import com.example.movieappandroid.util.JSONArrayAdapter
import com.example.movieappandroid.util.JSONObjectAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMoviesDataBase(@ApplicationContext context: Context): MoviesDB {
        return Room.databaseBuilder(
            context,
            MoviesDB::class.java,
            "movies.db"
        ).build()
    }

    @Singleton
    @Provides
    fun providesMoshiKotlinJsonAdapterFactory(): KotlinJsonAdapterFactory =
        KotlinJsonAdapterFactory()

    @Singleton
    @Provides
    fun provideMoshiRetrofitConverterFactory(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)

    @Singleton
    @Provides
    fun providesMoshi(kotlinJsonAdapterFactory: KotlinJsonAdapterFactory): Moshi {
        return Moshi.Builder()
            .add(kotlinJsonAdapterFactory)
            .add(JSONObjectAdapter)
            .add(JSONArrayAdapter)
            .build()
    }

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HeadersInterceptor())
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        httpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(moshiConverterFactory)
            .client(httpClient)
            .build()

    @Singleton
    @Provides
    fun provideRetrofitInstance(
        httpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory,
    ): MoviesService =
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(moshiConverterFactory)
            .build()
            .create(MoviesService::class.java)


}