package com.example.themovieapplication

import com.example.themovieapplication.models.MyMovieResponse
import retrofit2.Response
import javax.inject.Inject

class UseCaseImp @Inject constructor(val moviesRepository: MoviesRepository):UseCase {
    override suspend fun getMoviesUC(): Response<MyMovieResponse> {
        return moviesRepository.getMovieList()
    }
}