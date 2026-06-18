package com.example.multiplatforproject.presentation.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.multiplatforproject.data.remote.ApiResult
import com.example.multiplatforproject.data.repository.ProfileRepository
import com.example.multiplatforproject.presentation.profile.model.ProfileState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class ProfileViewModel {

    private val repository = ProfileRepository()

    private val scope = CoroutineScope(
        SupervisorJob() + Dispatchers.Main
    )

    var state by mutableStateOf(
        ProfileState()
    )
        private set

    fun loadProfile() {

        scope.launch {

            state = state.copy(
                isLoading = true,
                error = null
            )

            when (
                val result = repository.getProfile()
            ) {

                is ApiResult.Success -> {

                    state = state.copy(
                        user = result.data,
                        isLoading = false
                    )
                }

                is ApiResult.Error -> {

                    state = state.copy(
                        error = result.message,
                        isLoading = false
                    )
                }
            }
        }
    }
}