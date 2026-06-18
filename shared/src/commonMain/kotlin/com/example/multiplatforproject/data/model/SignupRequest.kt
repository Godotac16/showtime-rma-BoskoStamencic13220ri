package com.example.multiplatforproject.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignupRequest(

    @SerialName("full_name")
    val fullName: String,

    val username: String,

    val password: String
)