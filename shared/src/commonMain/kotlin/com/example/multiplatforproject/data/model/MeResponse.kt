package com.example.multiplatforproject.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MeResponse(
    val id: Int,
    val username: String,
    val full_name: String
)