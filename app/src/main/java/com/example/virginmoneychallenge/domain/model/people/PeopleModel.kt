package com.example.virginmoneychallenge.domain.model.people


import com.example.virginmoneychallenge.data.dto.PeopleDTO
import com.google.gson.annotations.SerializedName

data class PeopleModelItem(
    @SerializedName("createdAt")
    val createdAt: String? = "",
    @SerializedName("firstName")
    val firstName: String? = "",
    @SerializedName("avatar")
    val avatar: String? = "",
    @SerializedName("lastName")
    val lastName: String? = "",
    @SerializedName("email")
    val email: String? = "",
    @SerializedName("jobtitle")
    val jobtitle: String? = "",
    @SerializedName("favouriteColor")
    val favouriteColor: String? = "",
    @SerializedName("id")
    val id: String? = "",


    @SerializedName("data")
    val data: Data? = Data(),
    @SerializedName("fromName")
    val fromName: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("size")
    val size: String? = "",
    @SerializedName("to")
    val to: String? = "",
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("{}")
    val x: String? = ""
)

fun PeopleModelItem.toDTO(): PeopleDTO {
    return PeopleDTO(
        createdAt = this.createdAt?.substringBefore("T"),
        firstName = this.firstName?.capitalize(),
        avatar = this.avatar,
        lastName = this.lastName?.capitalize(),
        email = this.email?.lowercase(),
        jobtitle = this.jobtitle?.capitalize(),
        favouriteColor = this.favouriteColor?.capitalize(),
        id = this.id
    )
}