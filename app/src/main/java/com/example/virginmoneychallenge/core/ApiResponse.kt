package com.example.virginmoneychallenge.core

import retrofit2.Response

sealed class ApiResponse<T> {
    class Success<T>(val data: T) : ApiResponse<T>()
    class Error<T>(val message: String) : ApiResponse<T>()
    object loading : ApiResponse<Boolean>()
}