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
import com.bimabagaskhoro.testberkatsoft.databinding.FragmentMoviePopularBinding
import com.bimabagaskhoro.testberkatsoft.ui.adapter.MovieAdapter
import com.bimabagaskhoro.testberkatsoft.ui.detail.DetailFragment
import com.bimabagaskhoro.testberkatsoft.vm.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviePopularFragment : Fragment() {

    private var _binding: FragmentMoviePopularBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MovieAdapter
    private val viewModelMovie: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMoviePopularBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MovieAdapter()

        initMoviePopular()

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
                        rvMoviePopular.layoutManager = GridLayoutManager(context, 3)
                        rvMoviePopular.setHasFixedSize(true)
                    }
                    adapter.onItemClicked = {
                        val bundle =
                            Bundle().apply { putParcelable(DetailFragment.EXTRA_DATA, it) }
                        findNavController().navigate(
                            R.id.action_moviePopularFragment_to_detailFragment,
                            bundle
                        )
                    }
                }
            }
        }
    }

}