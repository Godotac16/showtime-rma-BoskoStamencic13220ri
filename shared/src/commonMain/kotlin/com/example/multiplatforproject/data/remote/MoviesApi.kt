package com.example.multiplatforproject.data.remote

import com.example.multiplatforproject.data.model.Movie
import com.example.multiplatforproject.data.model.PaginatedResponse
import io.ktor.client.call.body
import io.ktor.client.request.get

object MoviesApi {

    private const val BASE_URL = "https://rma.finlab.rs"

    suspend fun getMovies(): ApiResult<List<Movie>> {

        return try {

            val response: PaginatedResponse<Movie> =
                HttpClientFactory.client.get(
                    "$BASE_URL/movies?page=1&page_size=20"
                ).body()

            ApiResult.Success(response.items)

        } catch (e: Exception) {

            ApiResult.Error(
                e.message ?: "Unknown error"
            )
        }
    }
}