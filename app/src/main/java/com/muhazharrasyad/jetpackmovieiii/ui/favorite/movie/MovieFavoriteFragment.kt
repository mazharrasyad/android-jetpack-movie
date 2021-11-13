package com.muhazharrasyad.jetpackmovieiii.ui.favorite.movie

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
import com.muhazharrasyad.jetpackmovieiii.databinding.FragmentMovieFavoriteBinding
import com.muhazharrasyad.jetpackmovieiii.viewmodel.ViewModelFactory

class MovieFavoriteFragment : Fragment() {

    private var _fragmentMovieFavoriteBinding: FragmentMovieFavoriteBinding? = null
    private val binding get() = _fragmentMovieFavoriteBinding

    private lateinit var viewModel: MovieFavoriteViewModel
    private lateinit var favoriteAdapter: MovieFavoriteAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _fragmentMovieFavoriteBinding = FragmentMovieFavoriteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvMovieFavorite)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MovieFavoriteViewModel::class.java]

            favoriteAdapter = MovieFavoriteAdapter()
            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getFavorites().observe(this, { movies ->
                binding?.progressBar?.visibility = View.GONE
                favoriteAdapter.submitList(movies)
            })

            binding?.rvMovieFavorite?.layoutManager = LinearLayoutManager(context)
            binding?.rvMovieFavorite?.setHasFixedSize(true)
            binding?.rvMovieFavorite?.adapter = favoriteAdapter
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val courseEntity = favoriteAdapter.getSwipedData(swipedPosition)
                courseEntity?.let { viewModel.setFavorite(it) }

                val snackbar = Snackbar.make(view as View, R.string.pesan_batal, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.pesan_setuju) { v ->
                    courseEntity?.let { viewModel.setFavorite(it) }
                }
                snackbar.show()
            }
        }
    })
}