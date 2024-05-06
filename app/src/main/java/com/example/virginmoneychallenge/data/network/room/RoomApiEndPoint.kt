package com.example.virginmoneychallenge.data.network.room

import com.example.virginmoneychallenge.core.Constant
import com.example.virginmoneychallenge.domain.rooms.model.RoomModel
import retrofit2.http.GET

interface RoomApiEndPoint {
    @GET(Constant.END_POINT_ROOMS)
    suspend fun getRoomsFromRemoteDataSource():List<RoomModel>
}