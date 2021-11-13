package com.muhazharrasyad.jetpackmovieiii.di

import android.content.Context
import com.muhazharrasyad.jetpackmovieiii.data.DataRepository
import com.muhazharrasyad.jetpackmovieiii.data.source.local.LocalDataSource
import com.muhazharrasyad.jetpackmovieiii.data.source.local.room.DataDatabase
import com.muhazharrasyad.jetpackmovieiii.data.source.remote.RemoteDataSource
import com.muhazharrasyad.jetpackmovieiii.utils.AppExecutors
import com.muhazharrasyad.jetpackmovieiii.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): DataRepository {

        val database = DataDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.dataDao())
        val appExecutors = AppExecutors()

        return DataRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}