package com.example.multiplatforproject.presentation.auth.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.multiplatforproject.data.remote.ApiResult
import com.example.multiplatforproject.data.remote.SessionManager
import com.example.multiplatforproject.data.repository.AuthRepository
import com.example.multiplatforproject.presentation.auth.model.AuthIntent
import com.example.multiplatforproject.presentation.auth.model.AuthState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class AuthViewModel {

    private val repository = AuthRepository()

    private val scope = CoroutineScope(
        SupervisorJob() + Dispatchers.Main
    )

    var state by mutableStateOf(AuthState())
        private set

    fun logout() {

        SessionManager.accessToken = ""

        state = AuthState()
    }

    fun onIntent(intent: AuthIntent) {

        when (intent) {

            is AuthIntent.FullNameChanged -> {
                state = state.copy(
                    fullName = intent.value
                )
            }

            is AuthIntent.UsernameChanged -> {
                state = state.copy(
                    username = intent.value
                )
            }

            is AuthIntent.PasswordChanged -> {
                state = state.copy(
                    password = intent.value
                )
            }

            AuthIntent.LoginClicked -> {
                login()
            }

            AuthIntent.SignupClicked -> {
                signup()
            }
        }
    }

    private fun login() {

        scope.launch {

            state = state.copy(
                isLoading = true,
                error = null
            )

            when (
                val result = repository.login(
                    username = state.username,
                    password = state.password
                )
            ) {

                is ApiResult.Success -> {

                    SessionManager.accessToken =
                        result.data.accessToken

                    state = state.copy(
                        isLoading = false,
                        isLoggedIn = true
                    )
                }

                is ApiResult.Error -> {

                    state = state.copy(
                        isLoading = false,
                        error = "Wrong username or password"
                    )
                }
            }
        }
    }

    private fun signup() {

        scope.launch {

            state = state.copy(
                isLoading = true,
                error = null
            )

            when (
                val result = repository.signup(
                    fullName = state.fullName,
                    username = state.username,
                    password = state.password
                )
            ) {

                is ApiResult.Success -> {

                    SessionManager.accessToken =
                        result.data.accessToken

                    state = state.copy(
                        isLoading = false,
                        isLoggedIn = true
                    )
                }

                is ApiResult.Error -> {

                    state = state.copy(
                        isLoading = false,
                        error = "Username already exists"
                    )
                }
            }
        }
    }
}