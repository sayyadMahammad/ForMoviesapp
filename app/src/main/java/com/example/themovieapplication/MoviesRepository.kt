package com.example.themovieapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.themovieapplication.models.MyMovies
import com.example.themovieapplication.service.MyMovieApiInterface
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val myMovieApiInterface: MyMovieApiInterface) : RepositoryInterface{

    override suspend fun getMovieList() = myMovieApiInterface.getMoviesList()

}