package com.example.virginmoneychallenge.domain.repository.room

import com.example.virginmoneychallenge.domain.model.room.RoomModel
import retrofit2.Response

interface RoomRepository {
    suspend fun getRoomsFromRemoteDataSource() : Response<List<RoomModel>>
}
