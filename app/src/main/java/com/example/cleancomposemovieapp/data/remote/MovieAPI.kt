package com.example.cleancomposemovieapp.data.remote

import com.example.cleancomposemovieapp.data.remote.dto.MovieDetailDto
import com.example.cleancomposemovieapp.data.remote.dto.MoviesDto
import com.example.cleancomposemovieapp.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString: String,
        @Query("apikey") apiKey : String = Constants.API_KEY
    ) : MoviesDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId: String,
        @Query("apikey") apiKey : String = Constants.API_KEY
    ) : MovieDetailDto

}