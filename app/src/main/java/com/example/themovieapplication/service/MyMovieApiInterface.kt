package com.example.themovieapplication.service

import com.example.themovieapplication.models.MyMovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MyMovieApiInterface{
    @GET("/3/movie/popular?api_key=ff1fab3874a59a1dec515210ed378a29")
    fun getMoviesList() : Call<MyMovieResponse>

}