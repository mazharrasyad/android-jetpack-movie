package com.muhazharrasyad.jetpackmovieiii.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.Movie
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.Tv
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.MovieEntity
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.TvEntity
import com.muhazharrasyad.jetpackmovieiii.vo.Resource

interface DataDataSource {

    // Movie
    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getMovieDetail(dataId: String): LiveData<Resource<Movie>>

    fun getFavoritedMovies(): LiveData<PagedList<MovieEntity>>

    fun setMovieFavorite(movie: MovieEntity, state: Boolean)

    // Tv
    fun getAllTvs(): LiveData<Resource<PagedList<TvEntity>>>

    fun getTvDetail(dataId: String): LiveData<Resource<Tv>>

    fun getFavoritedTvs(): LiveData<PagedList<TvEntity>>

    fun setTvFavorite(tv: TvEntity, state: Boolean)
}