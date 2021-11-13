package com.muhazharrasyad.jetpackmovieiii.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.muhazharrasyad.jetpackmovieiii.data.source.local.LocalDataSource
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.Movie
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.MovieEntity
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.Tv
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.TvEntity
import com.muhazharrasyad.jetpackmovieiii.data.source.remote.ApiResponse
import com.muhazharrasyad.jetpackmovieiii.data.source.remote.RemoteDataSource
import com.muhazharrasyad.jetpackmovieiii.data.source.remote.response.DataResponse
import com.muhazharrasyad.jetpackmovieiii.utils.AppExecutors
import com.muhazharrasyad.jetpackmovieiii.vo.Resource
import java.util.ArrayList

class FakeDataRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors)
    : DataDataSource {

    // Movie
    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<DataResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<DataResponse>>> =
                remoteDataSource.getAllMovies()

            public override fun saveCallResult(movieResponses: List<DataResponse>) {
                val movieList = java.util.ArrayList<MovieEntity>()
                for (response in movieResponses) {
                    val movie = MovieEntity(
                        response.dataId,
                        response.poster,
                        response.judul,
                        response.tanggal,
                        response.skor,
                        response.overview)
                    movieList.add(movie)
                }

                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getMovieDetail(dataId: String): LiveData<Resource<Movie>> {
        return object : NetworkBoundResource<Movie, List<DataResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<Movie> =
                localDataSource.getMovieDetail(dataId)

            override fun shouldFetch(data: Movie?): Boolean =
                data?.mMovie == null

            override fun createCall(): LiveData<ApiResponse<List<DataResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<DataResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.dataId,
                        response.poster,
                        response.judul,
                        response.tanggal,
                        response.skor,
                        response.overview,
                        false)

                    movieList.add(movie)
                }

                localDataSource.insertMovies(movieList)
            }

        }.asLiveData()
    }

    override fun getFavoritedMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoritedMovies(), config).build()
    }

    override fun setMovieFavorite(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }

    // Tv
    override fun getAllTvs(): LiveData<Resource<PagedList<TvEntity>>> {
        return object : NetworkBoundResource<PagedList<TvEntity>, List<DataResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TvEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvs(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<DataResponse>>> =
                remoteDataSource.getAllTvs()

            public override fun saveCallResult(tvResponses: List<DataResponse>) {
                val tvList = java.util.ArrayList<TvEntity>()
                for (response in tvResponses) {
                    val tv = TvEntity(
                        response.dataId,
                        response.poster,
                        response.judul,
                        response.tanggal,
                        response.skor,
                        response.overview)
                    tvList.add(tv)
                }

                localDataSource.insertTvs(tvList)
            }
        }.asLiveData()
    }

    override fun getTvDetail(dataId: String): LiveData<Resource<Tv>> {
        return object : NetworkBoundResource<Tv, List<DataResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<Tv> =
                localDataSource.getTvDetail(dataId)

            override fun shouldFetch(data: Tv?): Boolean =
                data?.mTv == null

            override fun createCall(): LiveData<ApiResponse<List<DataResponse>>> =
                remoteDataSource.getAllTvs()

            override fun saveCallResult(data: List<DataResponse>) {
                val tvList = ArrayList<TvEntity>()
                for (response in data) {
                    val tv = TvEntity(
                        response.dataId,
                        response.poster,
                        response.judul,
                        response.tanggal,
                        response.skor,
                        response.overview,
                        false)

                    tvList.add(tv)
                }

                localDataSource.insertTvs(tvList)
            }

        }.asLiveData()
    }

    override fun getFavoritedTvs(): LiveData<PagedList<TvEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoritedTvs(), config).build()
    }

    override fun setTvFavorite(tv: TvEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setTvFavorite(tv, state) }
}