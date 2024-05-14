package com.example.virginmoneychallenge.data.repository.room

import com.example.virginmoneychallenge.data.network.room.RoomApiEndPoint
import com.example.virginmoneychallenge.domain.repository.room.RoomRepository
import javax.inject.Inject

class RoomRepositoryImp @Inject constructor(private val roomApiEndPoint: RoomApiEndPoint):
    RoomRepository {
    override suspend fun getRoomsFromRemoteDataSource() = roomApiEndPoint.getRoomsFromRemoteDataSource()
}