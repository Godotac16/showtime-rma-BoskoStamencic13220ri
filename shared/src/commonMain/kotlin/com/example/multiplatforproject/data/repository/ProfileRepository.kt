package com.example.multiplatforproject.data.repository

import com.example.multiplatforproject.data.model.MeResponse
import com.example.multiplatforproject.data.remote.ApiResult
import com.example.multiplatforproject.data.remote.ProfileApi

class ProfileRepository {

    suspend fun getProfile(): ApiResult<MeResponse> {
        return ProfileApi.getProfile()
    }
}