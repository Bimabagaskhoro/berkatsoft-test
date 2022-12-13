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
import com.bimabagaskhoro.testberkatsoft.databinding.FragmentMovieUpcomingBinding
import com.bimabagaskhoro.testberkatsoft.ui.adapter.MovieAdapter
import com.bimabagaskhoro.testberkatsoft.ui.detail.DetailFragment
import com.bimabagaskhoro.testberkatsoft.vm.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieUpcomingFragment : Fragment() {

    private var _binding: FragmentMovieUpcomingBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MovieAdapter
    private val viewModelMovie: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMovieUpcomingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MovieAdapter()

        initMovieUpcoming()

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
                        rvMovieUpComing.layoutManager = GridLayoutManager(context, 3)
                        rvMovieUpComing.setHasFixedSize(true)
                    }
                    adapter.onItemClicked = {
                        val bundle =
                            Bundle().apply { putParcelable(DetailFragment.EXTRA_DATA, it) }
                        findNavController().navigate(
                            R.id.action_movieUpcomingFragment_to_detailFragment,
                            bundle
                        )
                    }
                }
            }
        }
    }

}