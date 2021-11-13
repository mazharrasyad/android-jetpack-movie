package com.muhazharrasyad.jetpackmovieiii.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.muhazharrasyad.jetpackmovieiii.data.DataRepository
import com.muhazharrasyad.jetpackmovieiii.di.Injection
import com.muhazharrasyad.jetpackmovieiii.ui.movie.MovieViewModel
import com.muhazharrasyad.jetpackmovieiii.ui.tv.TvViewModel
import com.muhazharrasyad.jetpackmovieiii.ui.detail.DetailViewModel
import com.muhazharrasyad.jetpackmovieiii.ui.favorite.movie.MovieFavoriteViewModel
import com.muhazharrasyad.jetpackmovieiii.ui.favorite.tv.TvFavoriteViewModel

class ViewModelFactory private constructor(private val mDataRepository: DataRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                ViewModelFactory(Injection.provideRepository(context)).apply { instance = this }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mDataRepository) as T
            }
            modelClass.isAssignableFrom(TvViewModel::class.java) -> {
                TvViewModel(mDataRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mDataRepository) as T
            }
            modelClass.isAssignableFrom(MovieFavoriteViewModel::class.java) -> {
                MovieFavoriteViewModel(mDataRepository) as T
            }
            modelClass.isAssignableFrom(TvFavoriteViewModel::class.java) -> {
                TvFavoriteViewModel(mDataRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}