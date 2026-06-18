package com.example.multiplatforproject.presentation.movies

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.multiplatforproject.data.remote.ApiResult
import com.example.multiplatforproject.data.repository.MovieDetailsRepository
import com.example.multiplatforproject.presentation.movies.model.MovieDetailsState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MovieDetailsViewModel {

    private val repository = MovieDetailsRepository()

    private val scope = CoroutineScope(
        SupervisorJob() + Dispatchers.Main
    )

    var state by mutableStateOf(
        MovieDetailsState()
    )
        private set

    fun loadMovie(
        imdbId: String
    ) {

        scope.launch {

            state = state.copy(
                isLoading = true,
                error = null
            )

            when (
                val result =
                    repository.getMovieDetails(imdbId)
            ) {

                is ApiResult.Success -> {

                    state = state.copy(
                        movie = result.data,
                        isLoading = false
                    )
                }

                is ApiResult.Error -> {

                    state = state.copy(
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}