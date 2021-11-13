package com.muhazharrasyad.jetpackmovieiii.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.muhazharrasyad.jetpackmovieiii.data.DataRepository
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.Movie
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.Tv
import com.muhazharrasyad.jetpackmovieiii.vo.Resource

class DetailViewModel(private val dataRepository: DataRepository) : ViewModel() {
    val dataId = MutableLiveData<String>()

    fun setSelectedData(dataId: String) {
        this.dataId.value = dataId
    }

    // Movie
    var movieDetail: LiveData<Resource<Movie>> = Transformations.switchMap(dataId) { mMovieId ->
        dataRepository.getMovieDetail(mMovieId)
    }

    fun setFavoriteMovie() {
        val dataResource = movieDetail.value
        if (dataResource != null) {
            val movieDetailData = dataResource.data
            if (movieDetailData != null) {
                val movieEntity = movieDetailData.mMovie
                val newState = !movieEntity.favorited
                dataRepository.setMovieFavorite(movieEntity, newState)
            }
        }
    }

    // Tv
    var tvDetail: LiveData<Resource<Tv>> = Transformations.switchMap(dataId) { mTvId ->
        dataRepository.getTvDetail(mTvId)
    }

    fun setFavoriteTv() {
        val dataResource = tvDetail.value
        if (dataResource != null) {
            val tvDetailData = dataResource.data
            if (tvDetailData != null) {
                val tvEntity = tvDetailData.mTv
                val newState = !tvEntity.favorited
                dataRepository.setTvFavorite(tvEntity, newState)
            }
        }
    }
}