package com.example.multiplatforproject.data.remote

import com.example.multiplatforproject.data.model.MeResponse
import io.ktor.client.call.body
import io.ktor.client.request.get

object ProfileApi {

    private const val BASE_URL = "https://rma.finlab.rs"

    suspend fun getProfile(): ApiResult<MeResponse> {

        return try {

            val response: MeResponse =
                HttpClientFactory.client.get(
                    "$BASE_URL/me"
                ).body()

            ApiResult.Success(response)

        } catch (e: Exception) {

            ApiResult.Error(
                e.message ?: "Unknown error"
            )
        }
    }
}