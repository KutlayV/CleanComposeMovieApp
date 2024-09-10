package com.example.cleancomposemovieapp.presentation.movies

import com.example.cleancomposemovieapp.domain.model.Movie

data class MoviesState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error : String = "",
    val search : String = "batman"
)
