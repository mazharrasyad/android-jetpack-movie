package com.muhazharrasyad.jetpackmovieiii.ui.favorite.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.muhazharrasyad.jetpackmovieiii.data.DataRepository
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.TvEntity

class TvFavoriteViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getFavorites(): LiveData<PagedList<TvEntity>> = dataRepository.getFavoritedTvs()

    fun setFavorite(tvEntity: TvEntity) {
        val newState = !tvEntity.favorited
        dataRepository.setTvFavorite(tvEntity, newState)
    }
}