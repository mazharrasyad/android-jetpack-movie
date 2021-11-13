package com.muhazharrasyad.jetpackmovieiii.ui.favorite.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.MovieEntity
import com.muhazharrasyad.jetpackmovieiii.databinding.ItemBinding
import com.muhazharrasyad.jetpackmovieiii.ui.detail.DetailActivity
import com.muhazharrasyad.jetpackmovieiii.ui.movie.MovieAdapter

class MovieFavoriteAdapter: PagedListAdapter<MovieEntity, MovieFavoriteAdapter.MovieFavoriteViewHolder>(
    DIFF_CALLBACK
) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.dataId == newItem.dataId
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieFavoriteViewHolder {
        val itemBinding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieFavoriteViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MovieFavoriteViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    fun getSwipedData(swipedPosition: Int): MovieEntity? = getItem(swipedPosition)

    inner class MovieFavoriteViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(movie.poster)
                    .into(imgPoster)
                tvJudul.text = movie.judul
                tvTanggal.text = movie.tanggal
                tvSkor.text = movie.skor
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, movie.dataId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}