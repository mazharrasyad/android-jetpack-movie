package com.muhazharrasyad.jetpackmovieiii.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.muhazharrasyad.jetpackmovieiii.data.source.local.LocalDataSource
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.Movie
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.MovieEntity
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.Tv
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.TvEntity
import com.muhazharrasyad.jetpackmovieiii.data.source.remote.RemoteDataSource
import com.muhazharrasyad.jetpackmovieiii.utils.AppExecutors
import com.muhazharrasyad.jetpackmovieiii.utils.DataDummy
import com.muhazharrasyad.jetpackmovieiii.utils.LiveDataTestUtil
import com.muhazharrasyad.jetpackmovieiii.utils.PagedListUtil
import com.muhazharrasyad.jetpackmovieiii.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class DataRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val dataRepository = FakeDataRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteMovies()
    private val movieId = movieResponses[0].dataId
    private val tvResponses = DataDummy.generateRemoteTvs()
    private val tvId = tvResponses[0].dataId

    // Movie
    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        dataRepository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val dummyEntity = MutableLiveData<Movie>()
        dummyEntity.value = DataDummy.generateMovieDetail(DataDummy.generateMovies()[0], false)
        `when`<LiveData<Movie>>(local.getMovieDetail(movieId)).thenReturn(dummyEntity)

        val movieEntities = LiveDataTestUtil.getValue(dataRepository.getMovieDetail(movieId))
        verify(local).getMovieDetail(movieId)
        assertNotNull(movieEntities.data)
        assertNotNull(movieEntities.data?.mMovie?.judul)
        assertEquals(movieResponses[0].judul, movieEntities.data?.mMovie?.judul)
    }

    @Test
    fun getFavoritedMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoritedMovies()).thenReturn(dataSourceFactory)
        dataRepository.getFavoritedMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateMovies()))
        verify(local).getFavoritedMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    // Tv
    @Test
    fun getAllTvs() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvEntity>
        `when`(local.getAllTvs()).thenReturn(dataSourceFactory)
        dataRepository.getAllTvs()

        val tvEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateTvs()))
        verify(local).getAllTvs()
        assertNotNull(tvEntities.data)
        assertEquals(tvResponses.size.toLong(), tvEntities.data?.size?.toLong())
    }

    @Test
    fun getTvDetail() {
        val dummyEntity = MutableLiveData<Tv>()
        dummyEntity.value = DataDummy.generateTvDetail(DataDummy.generateTvs()[0], false)
        `when`<LiveData<Tv>>(local.getTvDetail(tvId)).thenReturn(dummyEntity)

        val tvEntities = LiveDataTestUtil.getValue(dataRepository.getTvDetail(tvId))
        verify(local).getTvDetail(tvId)
        assertNotNull(tvEntities.data)
        assertNotNull(tvEntities.data?.mTv?.judul)
        assertEquals(tvResponses[0].judul, tvEntities.data?.mTv?.judul)
    }

    @Test
    fun getFavoritedTvs() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvEntity>
        `when`(local.getFavoritedTvs()).thenReturn(dataSourceFactory)
        dataRepository.getFavoritedTvs()

        val tvEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateTvs()))
        verify(local).getFavoritedTvs()
        assertNotNull(tvEntities)
        assertEquals(tvResponses.size.toLong(), tvEntities.data?.size?.toLong())
    }
}