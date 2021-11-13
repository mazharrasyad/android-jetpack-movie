package com.muhazharrasyad.jetpackmovieiii.utils

import android.content.Context
import com.muhazharrasyad.jetpackmovieiii.data.source.remote.response.DataResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<DataResponse> {
        val list = ArrayList<DataResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val dataId = movie.getString("dataId")
                val poster = movie.getString("poster")
                val judul = movie.getString("judul")
                val tanggal = movie.getString("tanggal")
                val skor = movie.getString("skor")
                val overview = movie.getString("overview")

                val movieResponse = DataResponse(dataId, poster, judul, tanggal, skor, overview)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTvs(): List<DataResponse> {
        val list = ArrayList<DataResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvs")
            for (i in 0 until listArray.length()) {
                val tv = listArray.getJSONObject(i)

                val dataId = tv.getString("dataId")
                val poster = tv.getString("poster")
                val judul = tv.getString("judul")
                val tanggal = tv.getString("tanggal")
                val skor = tv.getString("skor")
                val overview = tv.getString("overview")

                val tvResponse = DataResponse(dataId, poster, judul, tanggal, skor, overview)
                list.add(tvResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
}