package com.example.movieappandroid.di

import com.example.movieappandroid.data.api.ApiConstants
import com.example.movieappandroid.data.api.HeadersInterceptor
import com.example.movieappandroid.data.api.movies.MoviesService
import com.example.movieappandroid.util.JSONArrayAdapter
import com.example.movieappandroid.util.JSONObjectAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

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

    @Provides
    fun provideMoviesEndPoint(retrofit: Retrofit): MoviesService {
        return retrofit.create(MoviesService::class.java)
    }
}