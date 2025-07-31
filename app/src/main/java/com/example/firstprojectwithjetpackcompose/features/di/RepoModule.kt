package com.example.firstprojectwithjetpackcompose.features.di

import com.example.firstprojectwithjetpackcompose.features.data.repository.NewsRepositoryImpl
import com.example.firstprojectwithjetpackcompose.features.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    @Singleton
    abstract fun providesNewsRepository(
        newsRepositoryImpl: NewsRepositoryImpl
    ): NewsRepository
}