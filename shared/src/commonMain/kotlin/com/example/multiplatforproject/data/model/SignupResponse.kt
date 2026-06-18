package com.example.multiplatforproject.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignupResponse(

    @SerialName("access_token")
    val accessToken: String

)