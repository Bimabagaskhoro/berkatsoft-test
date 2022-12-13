package com.bimabagaskhoro.testberkatsoft.data.source.remote.network

import com.bimabagaskhoro.testberkatsoft.data.source.remote.response.ResponseMovie
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val API_KEY = "ccd9c27b8f45040c8f4e7ce05a91c88d"
    }

    // Now Playing
    @GET("movie/now_playing?api_key=$API_KEY&language=en-US&page=1")
    suspend fun getMovieNowPlaying(): ResponseMovie

    // Popular
    @GET("movie/popular?api_key=$API_KEY&language=en-US&page=1")
    suspend fun getMoviePopular(): ResponseMovie

    // Top Rated
    @GET("movie/top_rated?api_key=$API_KEY&language=en-US&page=1")
    suspend fun getMovieTopRated(): ResponseMovie

    // Upcoming
    @GET("movie/upcoming?api_key=$API_KEY&language=en-US&page=1")
    suspend fun getMovieUpcoming(): ResponseMovie
}