package com.bimabagaskhoro.testberkatsoft.domain.usecase

import com.bimabagaskhoro.testberkatsoft.data.Resource
import com.bimabagaskhoro.testberkatsoft.domain.model.ItemMovie
import com.bimabagaskhoro.testberkatsoft.domain.repository.IItemMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemMovieInteractor @Inject constructor(private val itemMovieRepository: IItemMovieRepository) :
    ItemMovieUseCase {
    override fun getMovieNowPlaying(): Flow<Resource<List<ItemMovie>>> =
        itemMovieRepository.getMovieNowPlaying()

    override fun getMoviePopular(): Flow<Resource<List<ItemMovie>>> =
        itemMovieRepository.getMoviePopular()

    override fun getMovieTopRated(): Flow<Resource<List<ItemMovie>>> =
        itemMovieRepository.getMovieTopRated()

    override fun getMovieUpcoming(): Flow<Resource<List<ItemMovie>>> =
        itemMovieRepository.getMovieUpcoming()
}