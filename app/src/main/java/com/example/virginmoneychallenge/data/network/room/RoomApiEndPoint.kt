package com.example.virginmoneychallenge.data.network.room

import com.example.virginmoneychallenge.core.Constant
import com.example.virginmoneychallenge.domain.model.room.RoomModel
import retrofit2.Response
import retrofit2.http.GET

interface RoomApiEndPoint {
    @GET(Constant.END_POINT_ROOMS)
    suspend fun getRoomsFromRemoteDataSource(): Response<List<RoomModel>>
}