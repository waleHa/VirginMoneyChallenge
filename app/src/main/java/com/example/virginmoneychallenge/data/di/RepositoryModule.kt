package com.example.virginmoneychallenge.data.di

import com.example.virginmoneychallenge.data.repository.RepositoryImpl
import com.example.virginmoneychallenge.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(
        repositoryImpl: RepositoryImpl
    ): Repository
}