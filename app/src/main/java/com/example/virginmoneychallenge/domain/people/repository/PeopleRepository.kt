package com.example.virginmoneychallenge.domain.people.repository

import android.util.Log
import com.example.virginmoneychallenge.data.network.PeopleApiEndPoints
import com.example.virginmoneychallenge.domain.people.model.PeopleDTO
import com.example.virginmoneychallenge.domain.people.model.toDTO
import javax.inject.Inject

class PeopleRepository @Inject constructor(private val peopleApiEndPoints: PeopleApiEndPoints) {
//    suspend fun getPeopleListFromRemoteDataSource() =
//        peopleApiEndPoints.getPeopleListFromRemoteDataSource().map {
//            it.toDTO()
//        }
suspend fun getPeopleListFromRemoteDataSource() : List<PeopleDTO> {
    try {
        val startTime = System.currentTimeMillis()
        val result = peopleApiEndPoints.getPeopleListFromRemoteDataSource().map { it.toDTO() }
        val endTime = System.currentTimeMillis()
        Log.d("TAG: PeopleRepository", "Fetch and conversion took: ${endTime - startTime} ms")
        return result
    } catch (e: Exception) {
        Log.e("TAG: PeopleRepository", "Error fetching people data: ${e.message}")
        throw e // Re-throw if you want to handle this higher up in your call stack
    }
}
}