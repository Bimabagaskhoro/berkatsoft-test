package com.bimabagaskhoro.testberkatsoft.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bimabagaskhoro.testberkatsoft.R
import com.bimabagaskhoro.testberkatsoft.data.Resource
import com.bimabagaskhoro.testberkatsoft.databinding.FragmentMovieTopRatedBinding
import com.bimabagaskhoro.testberkatsoft.ui.adapter.MovieAdapter
import com.bimabagaskhoro.testberkatsoft.ui.detail.DetailFragment
import com.bimabagaskhoro.testberkatsoft.vm.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieTopRatedFragment : Fragment() {

    private var _binding: FragmentMovieTopRatedBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MovieAdapter
    private val viewModelMovie: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMovieTopRatedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MovieAdapter()

        initMovieTopRated()

    }

    private fun initMovieTopRated() {
        viewModelMovie.getMovieTopRated().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressbar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    adapter.setData(it.data!!)
                    binding.apply {
                        progressbar.visibility = View.GONE
                        rvMovieTopRated.adapter = adapter
                        rvMovieTopRated.layoutManager = GridLayoutManager(context, 3)
                        rvMovieTopRated.setHasFixedSize(true)
                    }
                    adapter.onItemClicked = {
                        val bundle =
                            Bundle().apply { putParcelable(DetailFragment.EXTRA_DATA, it) }
                        findNavController().navigate(
                            R.id.action_movieTopRatedFragment_to_detailFragment,
                            bundle
                        )
                    }
                }
            }
        }
    }

}