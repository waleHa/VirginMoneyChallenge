package com.example.virginmoneychallenge.data.network

import com.example.virginmoneychallenge.core.Constant
import com.example.virginmoneychallenge.data.dto.PeopleDTO
import com.example.virginmoneychallenge.domain.model.people.PeopleModelItem
import com.example.virginmoneychallenge.domain.model.room.RoomModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiEndPoints {
    @GET(Constant.END_POINT_PEOPLE)
    suspend fun getPeopleListFromRemoteDataSource(): Response<List<PeopleDTO>>
    @GET(Constant.END_POINT_ROOMS)
    suspend fun getRoomsFromRemoteDataSource(): Response<List<RoomModel>>
}