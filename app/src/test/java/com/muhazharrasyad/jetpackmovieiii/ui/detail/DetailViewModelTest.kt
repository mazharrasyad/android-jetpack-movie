package com.muhazharrasyad.jetpackmovieiii.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.muhazharrasyad.jetpackmovieiii.data.DataRepository
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.Movie
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.Tv
import com.muhazharrasyad.jetpackmovieiii.utils.DataDummy
import com.muhazharrasyad.jetpackmovieiii.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModelMovie: DetailViewModel
    private lateinit var viewModelTv: DetailViewModel
    private val dummyMovie = DataDummy.generateMovies()[0]
    private val dummyTv = DataDummy.generateTvs()[0]
    private val movieId = dummyMovie.dataId
    private val tvId = dummyTv.dataId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observerMovie: Observer<Resource<Movie>>

    @Mock
    private lateinit var observerTv: Observer<Resource<Tv>>

    @Before
    fun setUp() {
        viewModelMovie = DetailViewModel(dataRepository)
        viewModelTv = DetailViewModel(dataRepository)
        viewModelMovie.setSelectedData(movieId)
        viewModelTv.setSelectedData(tvId)
    }

    @Test
    fun getMovieDetail() {
        val dummyMovieDetail = Resource.success(DataDummy.generateMovieDetail(dummyMovie, true))
        val movie = MutableLiveData<Resource<Movie>>()
        movie.value = dummyMovieDetail

        `when`(dataRepository.getMovieDetail(movieId)).thenReturn(movie)

        viewModelMovie.movieDetail.observeForever(observerMovie)

        verify(observerMovie).onChanged(dummyMovieDetail)
    }

    @Test
    fun getTvDetail() {
        val dummyTvDetail = Resource.success(DataDummy.generateTvDetail(dummyTv, true))
        val tv = MutableLiveData<Resource<Tv>>()
        tv.value = dummyTvDetail

        `when`(dataRepository.getTvDetail(tvId)).thenReturn(tv)

        viewModelTv.tvDetail.observeForever(observerTv)

        verify(observerTv).onChanged(dummyTvDetail)
    }
}