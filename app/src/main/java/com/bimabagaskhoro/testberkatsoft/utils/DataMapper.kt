package com.bimabagaskhoro.testberkatsoft.utils

import com.bimabagaskhoro.testberkatsoft.data.source.remote.response.ResultsItem
import com.bimabagaskhoro.testberkatsoft.domain.model.ItemMovie

object DataMapper {

    fun entitiesToDomain(data: List<ResultsItem>): List<ItemMovie> =
        data.map {
            ItemMovie(
                overview = it.overview,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                video = it.video,
                title = it.title,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                releaseDate = it.releaseDate,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                id = it.id,
                adult = it.adult,
                voteCount = it.voteCount
            )
        }
}