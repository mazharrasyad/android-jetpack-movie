package com.muhazharrasyad.jetpackmovieiii.data.source.local.entity

import androidx.room.Embedded

data class Tv (
    @Embedded
    var mTv: TvEntity
)