package com.example.themovieapplication

import com.example.themovieapplication.models.MyMovieResponse
import retrofit2.Response

interface RepositoryInterface {
    suspend fun getMovieList(): Response<MyMovieResponse>
}