package com.example.multiplatforproject.presentation.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.multiplatforproject.presentation.movies.model.MoviesIntent

@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel
) {

    val state = viewModel.state

    LaunchedEffect(Unit) {
        viewModel.onIntent(
            MoviesIntent.LoadMovies
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Movies",
            style = MaterialTheme.typography.headlineMedium
        )

        if (state.isLoading) {
            Text("Loading...")
        }

        state.error?.let {
            Text(it)
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(state.movies) { movie ->

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = movie.title,
                            style = MaterialTheme.typography.titleMedium
                        )

                        movie.year?.let {
                            Text("Year: $it")
                        }

                        movie.imdbRating?.let {
                            Text("IMDb Rating: $it")
                        }
                    }
                }
            }
        }
    }
}