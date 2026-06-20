package com.example.multiplatforproject.presentation.quiz.model

data class QuizQuestion(

    val question: String,

    val answers: List<String>,

    val correctAnswer: String
)