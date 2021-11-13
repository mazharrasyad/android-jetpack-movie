package com.muhazharrasyad.jetpackmovieiii.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tventities")
data class TvEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "dataId")
    var dataId: String,

    @ColumnInfo(name = "poster")
    var poster: String,

    @ColumnInfo(name = "judul")
    var judul: String,

    @ColumnInfo(name = "tanggal")
    var tanggal: String,

    @ColumnInfo(name = "skor")
    var skor: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "favorited")
    var favorited: Boolean = false
)