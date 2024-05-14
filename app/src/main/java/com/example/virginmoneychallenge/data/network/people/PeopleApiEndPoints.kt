package com.example.virginmoneychallenge.data.network

import com.example.virginmoneychallenge.core.Constant
import com.example.virginmoneychallenge.domain.model.people.PeopleModelItem
import retrofit2.Response
import retrofit2.http.GET

interface PeopleApiEndPoints {
    @GET(Constant.END_POINT_PEOPLE)
    suspend fun getPeopleListFromRemoteDataSource(): Response<List<PeopleModelItem>>
}