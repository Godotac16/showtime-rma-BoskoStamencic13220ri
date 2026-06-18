package com.example.multiplatforproject.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SignupRequest(
    val full_name: String,
    val username: String,
    val password: String
)