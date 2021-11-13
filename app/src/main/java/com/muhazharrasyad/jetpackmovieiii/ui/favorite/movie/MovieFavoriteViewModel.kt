package com.muhazharrasyad.jetpackmovieiii.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.muhazharrasyad.jetpackmovieiii.data.DataRepository
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.MovieEntity

class MovieFavoriteViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getFavorites(): LiveData<PagedList<MovieEntity>> = dataRepository.getFavoritedMovies()

    fun setFavorite(movieEntity: MovieEntity) {
        val newState = !movieEntity.favorited
        dataRepository.setMovieFavorite(movieEntity, newState)
    }
}