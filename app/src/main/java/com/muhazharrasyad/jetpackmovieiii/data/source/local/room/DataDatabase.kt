package com.muhazharrasyad.jetpackmovieiii.data.source.local.room

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.MovieEntity
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.TvEntity

@Database(entities = [MovieEntity::class, TvEntity::class], version = 1, exportSchema = false)
abstract class DataDatabase : RoomDatabase() {
    abstract fun dataDao(): DataDao

    companion object {

        @Volatile
        private var INSTANCE: DataDatabase? = null

        fun getInstance(context: Context): DataDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    DataDatabase::class.java,
                    "Datas.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}