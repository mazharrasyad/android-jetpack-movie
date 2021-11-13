package com.muhazharrasyad.jetpackmovieiii.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.muhazharrasyad.jetpackmovieiii.R
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.MovieEntity
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.TvEntity
import com.muhazharrasyad.jetpackmovieiii.databinding.ActivityDetailBinding
import com.muhazharrasyad.jetpackmovieiii.databinding.ContentDetailBinding
import com.muhazharrasyad.jetpackmovieiii.viewmodel.ViewModelFactory
import com.muhazharrasyad.jetpackmovieiii.vo.Status

class DetailActivity : AppCompatActivity() {
    private lateinit var activityDetailBinding: ActivityDetailBinding
    private lateinit var detailContentBinding: ContentDetailBinding

    private lateinit var viewModelMovie: DetailViewModel
    private lateinit var viewModelTv: DetailViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailBinding.detailContent

        setContentView(activityDetailBinding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModelMovie = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        viewModelTv = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            val tvId = extras.getString(EXTRA_TV)
            // Saran dicoding
            if (movieId != null) {
                viewModelMovie.setSelectedData(movieId)

                viewModelMovie.movieDetail.observe(this, { movieDetailDataResource ->
                    if (movieDetailDataResource != null) {
                        when (movieDetailDataResource.status) {
                            Status.LOADING -> activityDetailBinding.progressBar.visibility = View.VISIBLE
                            Status.SUCCESS -> if (movieDetailDataResource.data != null) {
                                activityDetailBinding.progressBar.visibility = View.GONE
                                activityDetailBinding.content.visibility = View.VISIBLE
                                populateMovie(movieDetailDataResource.data.mMovie)
                            }
                            Status.ERROR -> {
                                activityDetailBinding.progressBar.visibility = View.GONE
                                Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            } else if (tvId != null){
                viewModelTv.setSelectedData(tvId)

                viewModelTv.tvDetail.observe(this, { tvDetailDataResource ->
                    if (tvDetailDataResource != null) {
                        when (tvDetailDataResource.status) {
                            Status.LOADING -> activityDetailBinding.progressBar.visibility = View.VISIBLE
                            Status.SUCCESS -> if (tvDetailDataResource.data != null) {
                                activityDetailBinding.progressBar.visibility = View.GONE
                                activityDetailBinding.content.visibility = View.VISIBLE
                                populateTv(tvDetailDataResource.data.mTv)
                            }
                            Status.ERROR -> {
                                activityDetailBinding.progressBar.visibility = View.GONE
                                Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }
    }

    private fun populateMovie(movieEntity: MovieEntity) {
        Glide.with(this)
            .load(movieEntity.poster)
            .transform(RoundedCorners(20))
            .error(R.drawable.poster_sample) // Saran dicoding
            .into(detailContentBinding.imgPoster)
        // Saran dicoding
        detailContentBinding.apply {
            tvJudul.text = movieEntity.judul
            tvTanggal.text = movieEntity.tanggal
            tvSkor.text = movieEntity.skor
            tvOverview.text = movieEntity.overview
        }
    }

    private fun populateTv(tvEntity: TvEntity) {
        Glide.with(this)
            .load(tvEntity.poster)
            .transform(RoundedCorners(20))
            .error(R.drawable.poster_sample) // Saran dicoding
            .into(detailContentBinding.imgPoster)
        // Saran dicoding
        detailContentBinding.apply {
            tvJudul.text = tvEntity.judul
            tvTanggal.text = tvEntity.tanggal
            tvSkor.text = tvEntity.skor
            tvOverview.text = tvEntity.overview
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        // Movie
        viewModelMovie.movieDetail.observe(this, { movieDetailData ->
            if (movieDetailData != null) {
                when (movieDetailData.status) {
                    Status.LOADING -> activityDetailBinding.progressBar.visibility = View.GONE
                    Status.SUCCESS -> if (movieDetailData.data != null) {
                        activityDetailBinding.progressBar.visibility = View.GONE
                        val state = movieDetailData.data.mMovie.favorited
                        setFavoriteMovieState(state)
                    }
                    Status.ERROR -> {
                        activityDetailBinding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        // Tv
        viewModelTv.tvDetail.observe(this, { tvDetailData ->
            if (tvDetailData != null) {
                when (tvDetailData.status) {
                    Status.LOADING -> activityDetailBinding.progressBar.visibility = View.GONE
                    Status.SUCCESS -> if (tvDetailData.data != null) {
                        activityDetailBinding.progressBar.visibility = View.GONE
                        val state = tvDetailData.data.mTv.favorited
                        setFavoriteTvState(state)
                    }
                    Status.ERROR -> {
                        activityDetailBinding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            viewModelMovie.setFavoriteMovie()
            viewModelTv.setFavoriteTv()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteMovieState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorited)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        }
    }

    private fun setFavoriteTvState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorited)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        }
    }

    // Saran dicoding
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV = "extra_tv"
    }
}