package com.example.multiplatforproject.data.remote

import com.example.multiplatforproject.data.model.MovieDetails
import io.ktor.client.call.body
import io.ktor.client.request.get

object MovieDetailsApi {

    private const val BASE_URL = "https://rma.finlab.rs"

    suspend fun getMovieDetails(
        imdbId: String
    ): ApiResult<MovieDetails> {

        return try {

            val response: MovieDetails =
                HttpClientFactory.client.get(
                    "$BASE_URL/movies/$imdbId"
                ).body()

            ApiResult.Success(response)

        } catch (e: Exception) {

            ApiResult.Error(
                e.message ?: "Unknown error"
            )
        }
    }
}