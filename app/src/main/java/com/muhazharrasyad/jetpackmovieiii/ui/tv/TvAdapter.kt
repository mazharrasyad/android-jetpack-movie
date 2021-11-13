package com.muhazharrasyad.jetpackmovieiii.ui.tv

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.TvEntity
import com.muhazharrasyad.jetpackmovieiii.databinding.ItemBinding
import com.muhazharrasyad.jetpackmovieiii.ui.detail.DetailActivity

class TvAdapter : PagedListAdapter<TvEntity, TvAdapter.TvViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvEntity>() {
            override fun areItemsTheSame(oldItem: TvEntity, newItem: TvEntity): Boolean {
                return oldItem.dataId == newItem.dataId
            }

            override fun areContentsTheSame(oldItem: TvEntity, newItem: TvEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val itemBinding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val tv = getItem(position)
        if (tv != null) {
            holder.bind(tv)
        }
    }

    class TvViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tv: TvEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(tv.poster)
                    .into(imgPoster)
                tvJudul.text = tv.judul
                tvTanggal.text = tv.tanggal
                tvSkor.text = tv.skor
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TV, tv.dataId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}