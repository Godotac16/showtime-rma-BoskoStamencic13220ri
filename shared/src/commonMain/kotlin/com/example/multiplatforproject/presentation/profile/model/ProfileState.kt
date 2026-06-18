package com.example.multiplatforproject.presentation.profile.model

import com.example.multiplatforproject.data.model.MeResponse

data class ProfileState(

    val user: MeResponse? = null,

    val isLoading: Boolean = false,

    val error: String? = null
)