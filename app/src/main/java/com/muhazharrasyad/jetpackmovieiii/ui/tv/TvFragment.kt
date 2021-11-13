package com.muhazharrasyad.jetpackmovieiii.ui.tv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhazharrasyad.jetpackmovieiii.databinding.FragmentTvBinding
import com.muhazharrasyad.jetpackmovieiii.viewmodel.ViewModelFactory
import com.muhazharrasyad.jetpackmovieiii.vo.Status

class TvFragment : Fragment() {

    private var _fragmentTvBinding: FragmentTvBinding? = null
    private val binding get() = _fragmentTvBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _fragmentTvBinding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvViewModel::class.java]
            val tvAdapter = TvAdapter()

            viewModel.getTvs().observe(this, { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding?.progressBar?.visibility = View.GONE
                            tvAdapter.submitList(movies.data)
                        }
                        Status.ERROR -> {
                            binding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(binding?.rvTv) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = tvAdapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentTvBinding = null
    }
}