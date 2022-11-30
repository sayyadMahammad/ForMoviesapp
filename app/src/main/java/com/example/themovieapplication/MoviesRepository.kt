package com.example.themovieapplication

import com.example.themovieapplication.models.MyMovieResponse
import com.example.themovieapplication.models.MyMovies
import retrofit2.Response

interface MoviesRepository {
    suspend fun getMovieList(): Response<MyMovieResponse>
    //suspend fun getMovieList(): Response<List<MyMovies>>
}