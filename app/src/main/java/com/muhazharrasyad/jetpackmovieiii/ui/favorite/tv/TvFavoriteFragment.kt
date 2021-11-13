package com.muhazharrasyad.jetpackmovieiii.ui.favorite.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.muhazharrasyad.jetpackmovieiii.R
import com.muhazharrasyad.jetpackmovieiii.databinding.FragmentTvFavoriteBinding
import com.muhazharrasyad.jetpackmovieiii.viewmodel.ViewModelFactory

class TvFavoriteFragment : Fragment() {

    private var _fragmentTvFavoriteBinding: FragmentTvFavoriteBinding? = null
    private val binding get() = _fragmentTvFavoriteBinding

    private lateinit var viewModel: TvFavoriteViewModel
    private lateinit var favoriteAdapter: TvFavoriteAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _fragmentTvFavoriteBinding = FragmentTvFavoriteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvTvFavorite)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[TvFavoriteViewModel::class.java]

            favoriteAdapter = TvFavoriteAdapter()
            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getFavorites().observe(this, { tvs ->
                binding?.progressBar?.visibility = View.GONE
                favoriteAdapter.submitList(tvs)
            })

            binding?.rvTvFavorite?.layoutManager = LinearLayoutManager(context)
            binding?.rvTvFavorite?.setHasFixedSize(true)
            binding?.rvTvFavorite?.adapter = favoriteAdapter
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val tvEntity = favoriteAdapter.getSwipedData(swipedPosition)
                tvEntity?.let { viewModel.setFavorite(it) }

                val snackbar = Snackbar.make(view as View, R.string.pesan_batal, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.pesan_setuju) { v ->
                    tvEntity?.let { viewModel.setFavorite(it) }
                }
                snackbar.show()
            }
        }
    })
}