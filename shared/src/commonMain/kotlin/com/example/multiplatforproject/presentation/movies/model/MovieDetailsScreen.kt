package com.example.multiplatforproject.presentation.movies

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
fun MovieDetailsScreen(
    viewModel: MovieDetailsViewModel
) {

    val state = viewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        if (state.isLoading) {
            Text("Loading...")
            return@Column
        }

        state.error?.let {
            Text(it)
            return@Column
        }

        state.movie?.let { movie ->

            Text(
                text = movie.title,
                style = MaterialTheme.typography.headlineMedium
            )

            movie.year?.let {
                Text("Year: $it")
            }

            movie.runtime?.let {
                Text("Runtime: $it min")
            }

            movie.imdbRating?.let {
                Text("IMDb Rating: $it")
            }

            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Add To Favorites")
            }

            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Add To Watchlist")
            }

            Text(
                text = movie.overview ?: "No overview available",
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}