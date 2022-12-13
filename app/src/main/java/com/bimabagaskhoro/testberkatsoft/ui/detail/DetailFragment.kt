package com.bimabagaskhoro.testberkatsoft.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bimabagaskhoro.testberkatsoft.databinding.FragmentDetailBinding
import com.bimabagaskhoro.testberkatsoft.domain.model.ItemMovie
import com.bimabagaskhoro.testberkatsoft.ui.adapter.MovieAdapter
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var data: ItemMovie

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            data = arguments?.getParcelable(EXTRA_DATA)!!
            binding.apply {
                tvTittleDetail.text = data.title
                tvReleaseDate.text = data.releaseDate
                tvOriginalLanguage.text = data.originalLanguage
                tvVoteAverage.text = data.voteCount.toString()
                tvOverview.text = data.overview

                context?.let {
                    Glide.with(it)
                        .load(LINK_IMAGE + data.posterPath)
                        .into(imageViewPoster)
                }
                context?.let {
                    Glide.with(it)
                        .load(LINK_IMAGE + data.backdropPath)
                        .into(backdropPath)
                }
            }
        }

    }
    companion object {
        const val EXTRA_DATA = "extra_data"
        const val LINK_IMAGE = "https://image.tmdb.org/t/p/w500"
    }

}