package com.example.multiplatforproject.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(

    val id: Int,

    val username: String,

    @SerialName("full_name")
    val fullName: String

)