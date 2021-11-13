package com.muhazharrasyad.jetpackmovieiii.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataResponse(
    var dataId: String,
    var poster: String,
    var judul: String,
    var tanggal: String,
    var skor: String,
    var overview: String
): Parcelable