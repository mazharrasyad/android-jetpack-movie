package com.muhazharrasyad.jetpackmovieiii.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.TvEntity
import com.muhazharrasyad.jetpackmovieiii.data.DataRepository
import com.muhazharrasyad.jetpackmovieiii.vo.Resource

class TvViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getTvs(): LiveData<Resource<PagedList<TvEntity>>> =
        dataRepository.getAllTvs()
}