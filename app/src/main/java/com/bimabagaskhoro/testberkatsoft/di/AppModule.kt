package com.bimabagaskhoro.testberkatsoft.di

import com.bimabagaskhoro.testberkatsoft.domain.usecase.ItemMovieInteractor
import com.bimabagaskhoro.testberkatsoft.domain.usecase.ItemMovieUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun provideMovieUseCase(itemMovieInteractor: ItemMovieInteractor): ItemMovieUseCase
}