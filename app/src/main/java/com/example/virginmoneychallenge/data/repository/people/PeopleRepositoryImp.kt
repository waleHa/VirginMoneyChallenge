package com.example.virginmoneychallenge.data.repository.people

import com.example.virginmoneychallenge.data.network.PeopleApiEndPoints
import com.example.virginmoneychallenge.domain.repository.people.PeopleRepository
import javax.inject.Inject

class PeopleRepositoryImp @Inject constructor(private val peopleApiEndPoints: PeopleApiEndPoints) : PeopleRepository {
    override suspend fun getPeopleListFromRemoteDataSource() =
        peopleApiEndPoints.getPeopleListFromRemoteDataSource()
}