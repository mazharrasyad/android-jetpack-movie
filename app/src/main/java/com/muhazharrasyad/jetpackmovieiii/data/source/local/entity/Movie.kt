package com.muhazharrasyad.jetpackmovieiii.data.source.local.entity

import androidx.room.Embedded

data class Movie (
    @Embedded
    var mMovie: MovieEntity
)