package com.example.multiplatforproject.presentation.movies.model

sealed interface MoviesIntent {

    data object LoadMovies : MoviesIntent
}