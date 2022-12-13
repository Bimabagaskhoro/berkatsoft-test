package com.bimabagaskhoro.testberkatsoft.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bimabagaskhoro.testberkatsoft.domain.usecase.ItemMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(val useCase: ItemMovieUseCase) : ViewModel() {
    fun getMovieNowPlaying() = useCase.getMovieNowPlaying().asLiveData()
    fun getMoviePopular() = useCase.getMoviePopular().asLiveData()
    fun getMovieTopRated() = useCase.getMovieTopRated().asLiveData()
    fun getMovieUpcoming() = useCase.getMovieUpcoming().asLiveData()
}