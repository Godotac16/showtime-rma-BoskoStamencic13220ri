package com.example.multiplatforproject.presentation.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuizScreen(
    viewModel: QuizViewModel,
    onBackClick: () -> Unit
) {

    val state = viewModel.state

    if (state.isFinished) {

        val wrongAnswers =
            state.questions.size - state.score

        val percentage =
            (state.score * 100) / state.questions.size

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 16.dp,
                    top = 100.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
        ) {

            Text(
                text = "Quiz Finished",
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "Final Score: ${state.score}/${state.questions.size}",
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = "Correct Answers: ${state.score}"
            )

            Text(
                text = "Wrong Answers: $wrongAnswers"
            )

            Text(
                text = "Success Rate: $percentage%"
            )

            Button(
                onClick = onBackClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Back To Movies")
            }
        }

        return
    }

    val question =
        state.questions[state.currentQuestionIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 16.dp,
                top = 100.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Exit Quiz")
        }

        Text(
            text = "Question ${state.currentQuestionIndex + 1}/${state.questions.size}",
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = question.question,
            style = MaterialTheme.typography.headlineSmall
        )

        question.answers.forEach { answer ->

            Button(
                onClick = {
                    viewModel.answer(answer)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(answer)
            }
        }
    }
}