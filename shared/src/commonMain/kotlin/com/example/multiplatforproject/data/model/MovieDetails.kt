package com.example.multiplatforproject.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieDetails(

    val imdbId: String,

    val title: String,

    val overview: String?,

    val year: Int?,

    val runtime: Int?,

    val imdbRating: Double?,

    val posterPath: String?,

    val backdropPath: String?,

    val genres: List<Genre>
)