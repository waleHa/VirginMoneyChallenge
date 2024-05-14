package com.example.virginmoneychallenge.data.repository

import com.example.virginmoneychallenge.data.network.ApiEndPoints
import com.example.virginmoneychallenge.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiEndPoints: ApiEndPoints) : Repository {
    override suspend fun getPeopleListFromRemoteDataSource() =
        apiEndPoints.getPeopleListFromRemoteDataSource()

    override suspend fun getRoomsFromRemoteDataSource() = apiEndPoints.getRoomsFromRemoteDataSource()
}