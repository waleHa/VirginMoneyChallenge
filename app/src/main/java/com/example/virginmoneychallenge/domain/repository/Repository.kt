package com.example.virginmoneychallenge.domain.repository

import com.example.virginmoneychallenge.data.dto.PeopleDTO
import com.example.virginmoneychallenge.domain.model.people.PeopleModelItem
import com.example.virginmoneychallenge.domain.model.room.RoomModel
import retrofit2.Response

interface Repository {
    suspend fun getPeopleListFromRemoteDataSource(): Response<List<PeopleDTO>>
    suspend fun getRoomsFromRemoteDataSource() : Response<List<RoomModel>>

}