package com.example.multiplatforproject.presentation.quiz

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.multiplatforproject.presentation.quiz.model.QuizQuestion
import com.example.multiplatforproject.presentation.quiz.model.QuizState

class QuizViewModel {

    var state by mutableStateOf(
        QuizState(
            questions = sampleQuestions().shuffled()
        )
    )
        private set

    fun restartQuiz() {
        state = QuizState(
            questions = sampleQuestions().shuffled()
        )
    }

    fun answer(answer: String) {

        val currentQuestion =
            state.questions[state.currentQuestionIndex]

        var newScore = state.score

        if (answer == currentQuestion.correctAnswer) {
            newScore++
        }

        val nextIndex =
            state.currentQuestionIndex + 1

        if (nextIndex >= state.questions.size) {

            state = state.copy(
                score = newScore,
                isFinished = true
            )

        } else {

            state = state.copy(
                score = newScore,
                currentQuestionIndex = nextIndex
            )
        }
    }

    companion object {

        private fun sampleQuestions(): List<QuizQuestion> {

            return listOf(

                QuizQuestion(
                    "Who directed Titanic?",
                    listOf(
                        "James Cameron",
                        "Christopher Nolan",
                        "Ridley Scott",
                        "Martin Scorsese"
                    ).shuffled(),
                    "James Cameron"
                ),

                QuizQuestion(
                    "In which year was The Matrix released?",
                    listOf(
                        "1999",
                        "2001",
                        "1995",
                        "2003"
                    ).shuffled(),
                    "1999"
                ),

                QuizQuestion(
                    "Who played Iron Man?",
                    listOf(
                        "Robert Downey Jr.",
                        "Chris Evans",
                        "Mark Ruffalo",
                        "Tom Holland"
                    ).shuffled(),
                    "Robert Downey Jr."
                ),

                QuizQuestion(
                    "Who directed Inception?",
                    listOf(
                        "Christopher Nolan",
                        "Steven Spielberg",
                        "James Cameron",
                        "David Fincher"
                    ).shuffled(),
                    "Christopher Nolan"
                ),

                QuizQuestion(
                    "Which movie features the character Jack Sparrow?",
                    listOf(
                        "Pirates of the Caribbean",
                        "Titanic",
                        "Avatar",
                        "Gladiator"
                    ).shuffled(),
                    "Pirates of the Caribbean"
                ),

                QuizQuestion(
                    "Who played Batman in The Dark Knight?",
                    listOf(
                        "Christian Bale",
                        "Ben Affleck",
                        "Robert Pattinson",
                        "Michael Keaton"
                    ).shuffled(),
                    "Christian Bale"
                ),

                QuizQuestion(
                    "Which movie won Best Picture in 1994?",
                    listOf(
                        "Forrest Gump",
                        "Pulp Fiction",
                        "The Shawshank Redemption",
                        "Speed"
                    ).shuffled(),
                    "Forrest Gump"
                ),

                QuizQuestion(
                    "What is the highest grossing movie of all time?",
                    listOf(
                        "Avatar",
                        "Titanic",
                        "Avengers Endgame",
                        "Frozen"
                    ).shuffled(),
                    "Avatar"
                ),

                QuizQuestion(
                    "Who directed Avatar?",
                    listOf(
                        "James Cameron",
                        "Christopher Nolan",
                        "Peter Jackson",
                        "Ridley Scott"
                    ).shuffled(),
                    "James Cameron"
                ),

                QuizQuestion(
                    "Which actor played Neo?",
                    listOf(
                        "Keanu Reeves",
                        "Tom Cruise",
                        "Brad Pitt",
                        "Matt Damon"
                    ).shuffled(),
                    "Keanu Reeves"
                )
            )
        }
    }
}