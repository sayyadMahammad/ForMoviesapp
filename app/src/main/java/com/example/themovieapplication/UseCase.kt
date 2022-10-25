package com.example.themovieapplication

import com.example.themovieapplication.models.MyMovieResponse
import retrofit2.Response

interface UseCase {
    suspend fun getMoviesUC():Response<MyMovieResponse>
}