package com.example.themovieapplication.service

import com.example.themovieapplication.models.MyMovieResponse
import com.example.themovieapplication.models.MyMovies
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


const val fullUrlPayments = "https://6377200d5c4777651214a95a.mockapi.io/paymentHistory"
interface MyMovieApiInterface{

    @GET("3/movie/top_rated?api_key=ff1fab3874a59a1dec515210ed378a29")
    suspend fun getMoviesList() : Response<MyMovieResponse>
//    @GET("paymentHistory")
//   suspend fun getMoviesList() : Response<List<MyMovies>>


}