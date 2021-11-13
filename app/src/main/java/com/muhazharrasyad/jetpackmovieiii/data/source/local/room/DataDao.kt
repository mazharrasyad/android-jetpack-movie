package com.muhazharrasyad.jetpackmovieiii.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.Movie
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.MovieEntity
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.Tv
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.TvEntity

@Dao
interface DataDao {
    // Movie
    @Query("SELECT * FROM movieentities")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities where favorited = 1")
    fun getFavoritedMovies(): DataSource.Factory<Int, MovieEntity>

    @Transaction
    @Query("SELECT * FROM movieentities WHERE dataId = :dataId")
    fun getMovieDetail(dataId: String): LiveData<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    // Tv
    @Query("SELECT * FROM tventities")
    fun getTvs(): DataSource.Factory<Int, TvEntity>

    @Query("SELECT * FROM tventities where favorited = 1")
    fun getFavoritedTvs(): DataSource.Factory<Int, TvEntity>

    @Transaction
    @Query("SELECT * FROM tventities WHERE dataId = :dataId")
    fun getTvDetail(dataId: String): LiveData<Tv>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvs(tvs: List<TvEntity>)

    @Update
    fun updateTv(tv: TvEntity)
}