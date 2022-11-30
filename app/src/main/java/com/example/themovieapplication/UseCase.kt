package com.example.themovieapplication

import com.example.themovieapplication.models.MyMovieResponse
import com.example.themovieapplication.models.MyMovies
import retrofit2.Response

interface UseCase {
   suspend fun getMoviesUC():Response<MyMovieResponse>
  // suspend fun getMoviesUC(): Response<List<MyMovies>>
}