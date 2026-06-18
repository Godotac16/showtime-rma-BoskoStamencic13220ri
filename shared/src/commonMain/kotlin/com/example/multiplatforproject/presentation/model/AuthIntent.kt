package com.example.multiplatforproject.presentation.auth.model

sealed interface AuthIntent {

    data class FullNameChanged(
        val value: String
    ) : AuthIntent

    data class UsernameChanged(
        val value: String
    ) : AuthIntent

    data class PasswordChanged(
        val value: String
    ) : AuthIntent

    data object LoginClicked : AuthIntent

    data object SignupClicked : AuthIntent
}