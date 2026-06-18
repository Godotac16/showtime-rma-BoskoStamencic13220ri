package com.example.multiplatforproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform