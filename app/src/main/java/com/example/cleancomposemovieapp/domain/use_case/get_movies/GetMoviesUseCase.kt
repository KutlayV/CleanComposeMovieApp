package com.example.cleancomposemovieapp.domain.use_case.get_movies

import android.net.http.HttpException
import com.example.cleancomposemovieapp.data.remote.dto.toMovieList
import com.example.cleancomposemovieapp.domain.model.Movie
import com.example.cleancomposemovieapp.domain.repository.MovieRepository
import com.example.cleancomposemovieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    //USE CASE İçerisinde TEK BİR FONKSİYON OLABİLİR!

    fun executeGetMovies(search : String) : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if (movieList.Response.equals("True")) {
                emit(Resource.Success(movieList.toMovieList()))
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