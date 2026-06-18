package com.example.multiplatforproject

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.multiplatforproject.navigation.Screen
import com.example.multiplatforproject.presentation.auth.LoginScreen
import com.example.multiplatforproject.presentation.auth.SignupScreen
import com.example.multiplatforproject.presentation.splash.SplashScreen
import com.example.multiplatforproject.presentation.auth.viewmodel.AuthViewModel
@Composable
fun App() {

    var currentScreen by remember {
        mutableStateOf(Screen.SPLASH)
    }

    val authViewModel = remember {
        AuthViewModel()
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
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("MOVIES SCREEN")
                }
            }
        }
    }
}