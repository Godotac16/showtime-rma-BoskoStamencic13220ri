package com.example.multiplatforproject.data.remote

import com.example.multiplatforproject.data.model.LoginRequest
import com.example.multiplatforproject.data.model.LoginResponse
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

object AuthApi {

    private const val BASE_URL = "https://rma.finlab.rs"

    suspend fun login(
        username: String,
        password: String
    ): ApiResult<LoginResponse> {

        return try {

            val response: LoginResponse =
                HttpClientFactory.client.post(
                    "$BASE_URL/auth/login"
                ) {
                    setBody(
                        LoginRequest(
                            username = username,
                            password = password
                        )
                    )
                }.body()

            ApiResult.Success(response)

        } catch (e: Exception) {

            ApiResult.Error(
                e.message ?: "Unknown error"
            )
        }
    }
}