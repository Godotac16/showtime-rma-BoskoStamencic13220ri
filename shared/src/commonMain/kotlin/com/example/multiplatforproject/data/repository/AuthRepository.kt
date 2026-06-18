package com.example.multiplatforproject.data.repository

import com.example.multiplatforproject.data.model.LoginResponse
import com.example.multiplatforproject.data.model.SignupResponse
import com.example.multiplatforproject.data.remote.ApiResult
import com.example.multiplatforproject.data.remote.AuthApi

class AuthRepository {

    suspend fun login(
        username: String,
        password: String
    ): ApiResult<LoginResponse> {

        return AuthApi.login(
            username = username,
            password = password
        )
    }

    suspend fun signup(
        fullName: String,
        username: String,
        password: String
    ): ApiResult<SignupResponse> {

        return AuthApi.signup(
            fullName = fullName,
            username = username,
            password = password
        )
    }
}