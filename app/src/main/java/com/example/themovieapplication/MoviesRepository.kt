package com.example.themovieapplication

import com.example.themovieapplication.models.MyMovieResponse
import retrofit2.Response

interface MoviesRepository {
    suspend fun getMovieList(): Response<MyMovieResponse>
}