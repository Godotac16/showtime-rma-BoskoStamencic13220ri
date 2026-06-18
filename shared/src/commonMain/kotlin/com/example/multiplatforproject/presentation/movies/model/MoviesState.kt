package com.example.multiplatforproject.presentation.movies.model

import com.example.multiplatforproject.data.model.Movie

data class MoviesState(

    val movies: List<Movie> = emptyList(),

    val isLoading: Boolean = false,

    val error: String? = null
)