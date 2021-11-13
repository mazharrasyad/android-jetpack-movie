package com.muhazharrasyad.jetpackmovieiii.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.Movie
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.MovieEntity
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.Tv
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.TvEntity
import com.muhazharrasyad.jetpackmovieiii.data.source.local.room.DataDao

class LocalDataSource private constructor(private val mDataDao: DataDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(dataDao: DataDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(dataDao).apply {
                INSTANCE = this
            }

    }

    // Movie
    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mDataDao.getMovies()

    fun getMovieDetail(dataId: String): LiveData<Movie> =
        mDataDao.getMovieDetail(dataId)

    fun getFavoritedMovies(): DataSource.Factory<Int, MovieEntity> =
        mDataDao.getFavoritedMovies()

    fun insertMovies(movies: List<MovieEntity>) {
        mDataDao.insertMovies(movies)
    }

    fun setMovieFavorite(movie: MovieEntity, newState: Boolean) {
        movie.favorited = newState
        mDataDao.updateMovie(movie)
    }

    // Tv
    fun getAllTvs(): DataSource.Factory<Int, TvEntity> = mDataDao.getTvs()

    fun getTvDetail(dataId: String): LiveData<Tv> =
        mDataDao.getTvDetail(dataId)

    fun getFavoritedTvs(): DataSource.Factory<Int, TvEntity> =
        mDataDao.getFavoritedTvs()

    fun insertTvs(tvs: List<TvEntity>) {
        mDataDao.insertTvs(tvs)
    }

    fun setTvFavorite(tv: TvEntity, newState: Boolean) {
        tv.favorited = newState
        mDataDao.updateTv(tv)
    }
}