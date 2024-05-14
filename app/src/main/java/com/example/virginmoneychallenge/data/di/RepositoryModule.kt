package com.example.virginmoneychallenge.data.di

import com.example.virginmoneychallenge.data.repository.people.PeopleRepositoryImpl
import com.example.virginmoneychallenge.data.repository.room.RoomRepositoryImpl
import com.example.virginmoneychallenge.domain.repository.people.PeopleRepository
import com.example.virginmoneychallenge.domain.repository.room.RoomRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule  {

    @Binds
    abstract fun bindRoomRepository(
        roomRepositoryImpl: RoomRepositoryImpl
    ): RoomRepository

    @Binds
    abstract fun bindPeopleRepository(
        peopleRepositoryImpl: PeopleRepositoryImpl
    ): PeopleRepository
}