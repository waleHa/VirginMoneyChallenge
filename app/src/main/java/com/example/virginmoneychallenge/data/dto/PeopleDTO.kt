package com.example.virginmoneychallenge.data.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PeopleDTO(
    val createdAt: String? = "",
    val firstName: String? = "",
    val avatar: String? = "",
    val lastName: String? = "",
    val email: String? = "",
    val jobtitle: String? = "",
    val favouriteColor: String? = "",
    val id: String? = ""
) : Parcelable