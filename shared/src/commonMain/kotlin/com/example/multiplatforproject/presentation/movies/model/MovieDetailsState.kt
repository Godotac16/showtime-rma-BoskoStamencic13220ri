package com.example.multiplatforproject.presentation.movies.model

import com.example.multiplatforproject.data.model.MovieDetails

data class MovieDetailsState(

    val movie: MovieDetails? = null,

    val isLoading: Boolean = false,

    val error: String? = null
)