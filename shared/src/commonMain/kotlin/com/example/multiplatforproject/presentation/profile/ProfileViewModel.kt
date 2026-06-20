package com.example.multiplatforproject.presentation.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.multiplatforproject.presentation.profile.model.ProfileState

class ProfileViewModel {

    var state by mutableStateOf(
        ProfileState()
    )
        private set

    fun loadProfile() {
        // nisam stigao da uradim api poziv
    }
}