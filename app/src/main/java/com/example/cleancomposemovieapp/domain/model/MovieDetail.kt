package com.example.cleancomposemovieapp.domain.model

import com.example.cleancomposemovieapp.data.remote.dto.Rating

data class MovieDetail(
    val actors: String,
    val awards: String,
    val country: String,
    val director: String,
    val genre: String,
    val language: String,
    val posterUrl: String,
    val rated: String,
    val ratings: List<Rating>,
    val released: String,
    val title: String,
    val type: String,
    val year: String,
    val imdbRating: String,
)
