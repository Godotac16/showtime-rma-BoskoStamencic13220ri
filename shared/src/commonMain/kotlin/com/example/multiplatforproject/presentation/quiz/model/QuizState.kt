package com.example.multiplatforproject.presentation.quiz.model

data class QuizState(

    val questions: List<QuizQuestion> = emptyList(),

    val currentQuestionIndex: Int = 0,

    val score: Int = 0,

    val isFinished: Boolean = false
)