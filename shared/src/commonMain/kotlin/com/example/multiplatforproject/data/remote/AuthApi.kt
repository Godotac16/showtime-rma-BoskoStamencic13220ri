package com.example.multiplatforproject.data.remote

import com.example.multiplatforproject.data.model.LoginRequest
import com.example.multiplatforproject.data.model.LoginResponse
import com.example.multiplatforproject.data.model.SignupRequest
import com.example.multiplatforproject.data.model.SignupResponse
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.JsonConvertException

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

                    contentType(ContentType.Application.Json)

                    setBody(
                        LoginRequest(
                            username = username,
                            password = password
                        )
                    )
                }.body()

            ApiResult.Success(response)

        } catch (e: JsonConvertException) {

            ApiResult.Error(
                "Wrong username or password"
            )

        } catch (e: Exception) {

            ApiResult.Error(
                e.message ?: "Unknown error"
            )
        }
    }

    suspend fun signup(
        fullName: String,
        username: String,
        password: String
    ): ApiResult<SignupResponse> {

        return try {

            val response: SignupResponse =
                HttpClientFactory.client.post(
                    "$BASE_URL/auth/signup"
                ) {

                    contentType(ContentType.Application.Json)

                    setBody(
                        SignupRequest(
                            fullName = fullName,
                            username = username,
                            password = password
                        )
                    )
                }.body()

            ApiResult.Success(response)

        } catch (e: JsonConvertException) {

            ApiResult.Error(
                "Username already exists or invalid data"
            )

        } catch (e: Exception) {

            ApiResult.Error(
                e.message ?: "Unknown error"
            )
        }
    }
}