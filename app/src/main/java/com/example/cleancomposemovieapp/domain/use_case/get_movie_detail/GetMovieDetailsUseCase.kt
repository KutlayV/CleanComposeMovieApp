package com.example.cleancomposemovieapp.domain.use_case.get_movie_detail

import com.example.cleancomposemovieapp.data.remote.dto.toMovieDetail
import com.example.cleancomposemovieapp.domain.model.MovieDetail
import com.example.cleancomposemovieapp.domain.repository.MovieRepository
import com.example.cleancomposemovieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val repository: MovieRepository) {
    fun executeGetMovieDetails(imdbID : String) : Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbID)
            if (movieDetail.Response.equals("True")) {
                emit(Resource.Success(movieDetail.toMovieDetail()))
            } else {
                emit(Resource.Error("No Movie Found!"))
            }
        } catch (e: IOError) {
            emit(Resource.Error("No Internet Connection"))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage?: "Error"))
        }
    }
}