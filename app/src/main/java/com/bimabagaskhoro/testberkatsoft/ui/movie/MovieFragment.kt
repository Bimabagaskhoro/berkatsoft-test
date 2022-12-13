package com.bimabagaskhoro.testberkatsoft.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bimabagaskhoro.testberkatsoft.R
import com.bimabagaskhoro.testberkatsoft.data.Resource
import com.bimabagaskhoro.testberkatsoft.databinding.FragmentMovieBinding
import com.bimabagaskhoro.testberkatsoft.ui.adapter.MovieAdapter
import com.bimabagaskhoro.testberkatsoft.ui.adapter.MovieAdapterLarge
import com.bimabagaskhoro.testberkatsoft.ui.detail.DetailFragment
import com.bimabagaskhoro.testberkatsoft.vm.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MovieAdapter
    private lateinit var adapterLarge: MovieAdapterLarge
    private val viewModelMovie: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MovieAdapter()
        adapterLarge = MovieAdapterLarge()
        initMovieNowPlaying()
        initMoviePopular()
        initMovieTopRated()
        initMovieUpcoming()

        binding.apply {
            tvDetailListComing.setOnClickListener {
                findNavController().navigate(R.id.action_movieFragment3_to_movieUpcomingFragment)
            }
            tvDetailListPopular.setOnClickListener {
                findNavController().navigate(R.id.action_movieFragment3_to_moviePopularFragment)
            }
            tvDetailListTopRated.setOnClickListener {
                findNavController().navigate(R.id.action_movieFragment3_to_movieTopRatedFragment)
            }
            tvHelpersNowPlaying.setOnClickListener {
                findNavController().navigate(R.id.action_movieFragment3_to_movieNowPlayingFragment)
            }
        }
    }

    private fun initMovieNowPlaying() {
        viewModelMovie.getMovieNowPlaying().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressbar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    adapterLarge.setData(it.data!!)
                    binding.apply {
                        progressbar.visibility = View.GONE
                        rvMovieNowPlaying.adapter = adapterLarge
                        rvMovieNowPlaying.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                        rvMovieNowPlaying.setHasFixedSize(true)
                    }
                    adapterLarge.onItemClicked = {
                        val bundle =
                            Bundle().apply { putParcelable(DetailFragment.EXTRA_DATA, it) }
                        findNavController().navigate(
                            R.id.action_movieFragment3_to_detailFragment,
                            bundle
                        )
                    }
                }
            }
        }
    }

    private fun initMoviePopular() {
        viewModelMovie.getMoviePopular().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressbar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    adapter.setData(it.data!!)
                    binding.apply {
                        progressbar.visibility = View.GONE
                        rvMoviePopular.adapter = adapter
                        rvMoviePopular.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                        rvMoviePopular.setHasFixedSize(true)
                    }
                    adapter.onItemClicked = {
                        val bundle =
                            Bundle().apply { putParcelable(DetailFragment.EXTRA_DATA, it) }
                        findNavController().navigate(
                            R.id.action_movieFragment3_to_detailFragment,
                            bundle
                        )
                    }
                }
            }
        }
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
                        rvMovieTopRated.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                        rvMovieTopRated.setHasFixedSize(true)
                    }
                    adapter.onItemClicked = {
                        val bundle =
                            Bundle().apply { putParcelable(DetailFragment.EXTRA_DATA, it) }
                        findNavController().navigate(
                            R.id.action_movieFragment3_to_detailFragment,
                            bundle
                        )
                    }
                }
            }
        }
    }

    private fun initMovieUpcoming() {
        viewModelMovie.getMovieUpcoming().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressbar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    adapter.setData(it.data!!)
                    binding.apply {
                        progressbar.visibility = View.GONE
                        rvMovieUpComing.adapter = adapter
                        rvMovieUpComing.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                        rvMovieUpComing.setHasFixedSize(true)
                    }
                    adapter.onItemClicked = {
                        val bundle =
                            Bundle().apply { putParcelable(DetailFragment.EXTRA_DATA, it) }
                        findNavController().navigate(
                            R.id.action_movieFragment3_to_detailFragment,
                            bundle
                        )
                    }
                }
            }
        }
    }

}