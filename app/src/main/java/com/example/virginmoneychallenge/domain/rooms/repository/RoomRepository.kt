package com.example.virginmoneychallenge.domain.rooms.repository

import com.example.virginmoneychallenge.data.network.room.RoomApiEndPoint
import com.example.virginmoneychallenge.domain.rooms.model.RoomModel
import javax.inject.Inject

class RoomRepository @Inject constructor(private val roomApiEndPoint: RoomApiEndPoint){
    suspend fun getRoomsFromRemoteDataSource() = roomApiEndPoint.getRoomsFromRemoteDataSource()
}