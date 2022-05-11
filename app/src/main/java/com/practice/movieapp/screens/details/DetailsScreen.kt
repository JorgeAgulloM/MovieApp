package com.practice.movieapp.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.practice.movieapp.model.Movie
import com.practice.movieapp.model.getMovies

@Composable
fun DetailsScreen(
    navController: NavController,
    movieId: String?
) {
    val newMovieList = getMovies().filter { movie ->
        movie.id == movieId
    }
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.primaryVariant,
            elevation = 5.dp
        ) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Bog Back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = "Movies")
            }
        }
    }) {
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = newMovieList[0].title,
                    style = MaterialTheme.typography.h5
                )
                /*Spacer(modifier = Modifier.height(23.dp))
                Button(onClick = {
                    navController.popBackStack()
                }) {
                    Text(text = "Go Back")
                }*/
            }
        }
    }


}