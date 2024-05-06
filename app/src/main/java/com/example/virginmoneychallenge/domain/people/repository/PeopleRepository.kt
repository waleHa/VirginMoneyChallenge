package com.example.virginmoneychallenge.domain.people.repository

import android.util.Log
import com.example.virginmoneychallenge.data.network.PeopleApiEndPoints
import com.example.virginmoneychallenge.domain.people.model.PeopleDTO
import com.example.virginmoneychallenge.domain.people.model.toDTO
import javax.inject.Inject

class PeopleRepository @Inject constructor(private val peopleApiEndPoints: PeopleApiEndPoints) {
    suspend fun getPeopleListFromRemoteDataSource() =
        peopleApiEndPoints.getPeopleListFromRemoteDataSource().map {
            it.toDTO()
        }
}