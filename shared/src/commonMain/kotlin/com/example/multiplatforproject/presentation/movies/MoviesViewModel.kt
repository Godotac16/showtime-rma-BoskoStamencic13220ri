package com.example.multiplatforproject.presentation.movies

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.multiplatforproject.data.remote.ApiResult
import com.example.multiplatforproject.data.repository.MoviesRepository
import com.example.multiplatforproject.presentation.movies.model.MoviesIntent
import com.example.multiplatforproject.presentation.movies.model.MoviesState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MoviesViewModel {

    private val repository = MoviesRepository()

    private val scope = CoroutineScope(
        SupervisorJob() + Dispatchers.Main
    )

    var state by mutableStateOf(MoviesState())
        private set

    fun onIntent(intent: MoviesIntent) {

        when (intent) {

            MoviesIntent.LoadMovies -> {
                loadMovies()
            }
        }
    }

    private fun loadMovies() {

        scope.launch {

            state = state.copy(
                isLoading = true,
                error = null
            )

            when (val result = repository.getMovies()) {

                is ApiResult.Success -> {

                    state = state.copy(
                        movies = result.data,
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