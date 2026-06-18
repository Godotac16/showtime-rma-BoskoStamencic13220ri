package com.example.multiplatforproject.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(

    val imdbId: String,

    val title: String,

    val year: Int?,

    val imdbRating: Double?,

    val imdbVotes: Int?,

    @SerialName("posterPath")
    val posterPath: String?,

    val genres: List<Genre>
)