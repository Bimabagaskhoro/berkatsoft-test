package com.bimabagaskhoro.testberkatsoft.data.source.remote

import android.util.Log
import com.bimabagaskhoro.testberkatsoft.data.source.remote.network.ApiResponse
import com.bimabagaskhoro.testberkatsoft.data.source.remote.network.ApiService
import com.bimabagaskhoro.testberkatsoft.data.source.remote.response.ResultsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    private val TAG = RemoteDataSource::class.java.simpleName

    suspend fun getMovieNowPlaying(): Flow<ApiResponse<List<ResultsItem>>> {
        return flow {
            try {
                val response = apiService.getMovieNowPlaying()
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.d(TAG, "getMovieNowPlaying: ${e.message}")
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getMoviePopular(): Flow<ApiResponse<List<ResultsItem>>> {
        return flow {
            try {
                val response = apiService.getMoviePopular()
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.d(TAG, "getMoviePopular: ${e.message}")
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getMovieTopRated(): Flow<ApiResponse<List<ResultsItem>>> {
        return flow {
            try {
                val response = apiService.getMovieTopRated()
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.d(TAG, "getMovieTopRated: ${e.message}")
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getMovieUpcoming(): Flow<ApiResponse<List<ResultsItem>>> {
        return flow {
            try {
                val response = apiService.getMovieUpcoming()
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.d(TAG, "getMovieUpcoming: ${e.message}")
            }
        }.flowOn(Dispatchers.IO)
    }
}