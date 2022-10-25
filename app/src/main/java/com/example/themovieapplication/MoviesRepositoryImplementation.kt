package com.example.themovieapplication

import com.example.themovieapplication.service.MyMovieApiInterface
import javax.inject.Inject

class MoviesRepositoryImplementation @Inject constructor(private val myMovieApiInterface: MyMovieApiInterface) : MoviesRepository{

    override suspend fun getMovieList() = myMovieApiInterface.getMoviesList()

}