package com.example.multiplatforproject

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.example.multiplatforproject.navigation.Screen
import com.example.multiplatforproject.presentation.auth.LoginScreen
import com.example.multiplatforproject.presentation.auth.SignupScreen
import com.example.multiplatforproject.presentation.auth.viewmodel.AuthViewModel
import com.example.multiplatforproject.presentation.movies.MoviesScreen
import com.example.multiplatforproject.presentation.movies.MoviesViewModel
import com.example.multiplatforproject.presentation.splash.SplashScreen

@Composable
fun App() {

    var currentScreen by remember {
        mutableStateOf(Screen.SPLASH)
    }

    val authViewModel = remember {
        AuthViewModel()
    }

    val moviesViewModel = remember {
        MoviesViewModel()
    }

    MaterialTheme {

        when (currentScreen) {

            Screen.SPLASH -> {
                SplashScreen(
                    onFinished = {
                        currentScreen = Screen.LOGIN
                    }
                )
            }

            Screen.LOGIN -> {
                LoginScreen(
                    viewModel = authViewModel,
                    onLoginClick = {
                        currentScreen = Screen.MOVIES
                    },
                    onSignupClick = {
                        currentScreen = Screen.SIGNUP
                    }
                )
            }

            Screen.SIGNUP -> {
                SignupScreen(
                    viewModel = authViewModel,
                    onCreateAccountClick = {
                        currentScreen = Screen.MOVIES
                    },
                    onLoginClick = {
                        currentScreen = Screen.LOGIN
                    }
                )
            }

            Screen.MOVIES -> {
                MoviesScreen(
                    viewModel = moviesViewModel
                )
            }
        }
    }
}