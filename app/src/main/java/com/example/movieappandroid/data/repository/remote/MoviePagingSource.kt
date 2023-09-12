package com.example.movieappandroid.data.repository.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movieappandroid.data.entities.mapFromListModel
import com.example.movieappandroid.domain.model.Movie
import okio.IOException
import retrofit2.HttpException

class MoviePagingSource(
    private val remoteDataSource: RemoteDataSource
) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val currentPage = params.key ?: 1
            val movies = remoteDataSource.getDiscoverMovies(currentPage)
            LoadResult.Page(
                data = movies.results!!.mapFromListModel(),
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (movies.results.isEmpty()) null else movies.page!! + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}