package com.example.multiplatforproject.data.repository

import com.example.multiplatforproject.data.model.Movie
import com.example.multiplatforproject.data.remote.ApiResult
import com.example.multiplatforproject.data.remote.MoviesApi

class MoviesRepository {

    suspend fun getMovies(): ApiResult<List<Movie>> {
        return MoviesApi.getMovies()
    }
}