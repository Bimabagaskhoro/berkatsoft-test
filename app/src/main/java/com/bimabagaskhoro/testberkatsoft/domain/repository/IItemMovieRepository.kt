package com.bimabagaskhoro.testberkatsoft.domain.repository

import com.bimabagaskhoro.testberkatsoft.data.Resource
import com.bimabagaskhoro.testberkatsoft.domain.model.ItemMovie
import kotlinx.coroutines.flow.Flow

interface IItemMovieRepository {
    fun getMovieNowPlaying(): Flow<Resource<List<ItemMovie>>>
    fun getMoviePopular(): Flow<Resource<List<ItemMovie>>>
    fun getMovieTopRated(): Flow<Resource<List<ItemMovie>>>
    fun getMovieUpcoming(): Flow<Resource<List<ItemMovie>>>
}