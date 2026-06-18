package com.example.multiplatforproject.data.repository

import com.example.multiplatforproject.data.model.MovieDetails
import com.example.multiplatforproject.data.remote.ApiResult
import com.example.multiplatforproject.data.remote.MovieDetailsApi

class MovieDetailsRepository {

    suspend fun getMovieDetails(
        imdbId: String
    ): ApiResult<MovieDetails> {

        return MovieDetailsApi.getMovieDetails(
            imdbId = imdbId
        )
    }
}