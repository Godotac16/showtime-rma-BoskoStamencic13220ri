package com.example.multiplatforproject.presentation.auth.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.multiplatforproject.presentation.auth.model.AuthIntent
import com.example.multiplatforproject.presentation.auth.model.AuthState

class AuthViewModel {

    var state by mutableStateOf(AuthState())
        private set

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
                println("Login clicked")
            }

            AuthIntent.SignupClicked -> {
                println("Signup clicked")
            }
        }
    }
}