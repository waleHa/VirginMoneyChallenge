package com.example.virginmoneychallenge.domain.repository.people

import com.example.virginmoneychallenge.domain.model.people.PeopleModelItem
import retrofit2.Response

interface PeopleRepository {
    suspend fun getPeopleListFromRemoteDataSource(): Response<List<PeopleModelItem>>
}