package com.bimabagaskhoro.testberkatsoft.data.source

import android.util.Log
import com.bimabagaskhoro.testberkatsoft.data.Resource
import com.bimabagaskhoro.testberkatsoft.data.source.remote.RemoteDataSource
import com.bimabagaskhoro.testberkatsoft.data.source.remote.network.ApiResponse
import com.bimabagaskhoro.testberkatsoft.domain.model.ItemMovie
import com.bimabagaskhoro.testberkatsoft.domain.repository.IItemMovieRepository
import com.bimabagaskhoro.testberkatsoft.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    IItemMovieRepository {
    private val TAG = MovieRepository::class.java.simpleName

    override fun getMovieNowPlaying(): Flow<Resource<List<ItemMovie>>> {
        return flow {
            when (val apiResponse = remoteDataSource.getMovieNowPlaying().first()) {
                is ApiResponse.Success -> {
                    emit(Resource.Success(DataMapper.entitiesToDomain(apiResponse.data!!)))
                }
                is ApiResponse.Error -> {
                    emit(Resource.Error(apiResponse.errorMessage!!))
                }
                is ApiResponse.Empty -> {
                    Log.d(TAG, "getMovieNowPlaying: Empty Data")
                }
            }
        }
    }

    override fun getMoviePopular(): Flow<Resource<List<ItemMovie>>> {
        return flow {
            when (val apiResponse = remoteDataSource.getMoviePopular().first()) {
                is ApiResponse.Success -> {
                    emit(Resource.Success(DataMapper.entitiesToDomain(apiResponse.data!!)))
                }
                is ApiResponse.Error -> {
                    emit(Resource.Error(apiResponse.errorMessage!!))
                }
                is ApiResponse.Empty -> {
                    Log.d(TAG, "getMoviePopular: Empty Data")
                }
            }
        }
    }

    override fun getMovieTopRated(): Flow<Resource<List<ItemMovie>>> {
        return flow {
            when (val apiResponse = remoteDataSource.getMovieTopRated().first()) {
                is ApiResponse.Success -> {
                    emit(Resource.Success(DataMapper.entitiesToDomain(apiResponse.data!!)))
                }
                is ApiResponse.Error -> {
                    emit(Resource.Error(apiResponse.errorMessage!!))
                }
                is ApiResponse.Empty -> {
                    Log.d(TAG, "getMovieTopRated: Empty Data")
                }
            }
        }
    }

    override fun getMovieUpcoming(): Flow<Resource<List<ItemMovie>>> {
        return flow {
            when (val apiResponse = remoteDataSource.getMovieUpcoming().first()) {
                is ApiResponse.Success -> {
                    emit(Resource.Success(DataMapper.entitiesToDomain(apiResponse.data!!)))
                }
                is ApiResponse.Error -> {
                    emit(Resource.Error(apiResponse.errorMessage!!))
                }
                is ApiResponse.Empty -> {
                    Log.d(TAG, "getMovieUpcoming: Empty Data")
                }
            }
        }
    }
}