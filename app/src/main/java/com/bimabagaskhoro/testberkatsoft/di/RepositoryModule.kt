package com.bimabagaskhoro.testberkatsoft.di

import com.bimabagaskhoro.testberkatsoft.data.source.MovieRepository
import com.bimabagaskhoro.testberkatsoft.domain.repository.IItemMovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(movieRepository: MovieRepository): IItemMovieRepository
}