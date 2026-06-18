package com.example.multiplatforproject.presentation.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel
) {

    val state = viewModel.state

    LaunchedEffect(Unit) {
        viewModel.loadProfile()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        if (state.isLoading) {
            Text("Loading...")
        }

        state.error?.let {
            Text(it)
        }

        state.user?.let { user ->

            Text(
                text = "Full Name: ${user.fullName}"
            )

            Text(
                text = "Username: ${user.username}"
            )

            Button(
                onClick = { }
            ) {
                Text("Logout")
            }
        }
    }
}