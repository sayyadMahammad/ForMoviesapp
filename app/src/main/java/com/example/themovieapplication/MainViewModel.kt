package com.example.themovieapplication

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.themovieapplication.models.MyMovieResponse
import com.example.themovieapplication.models.MyMovies
import com.example.themovieapplication.service.MovieApiService
import com.example.themovieapplication.service.MyMovieApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel :ViewModel() {


   suspend  fun getMovieData(callback: (List<MyMovies>)->Unit){

        val apiService = MovieApiService.getInstance().create(MyMovieApiInterface::class.java)

        apiService.getMoviesList().enqueue(object : Callback<MyMovieResponse> {
            override fun onResponse(
                call: Call<MyMovieResponse>,
                response: Response<MyMovieResponse>
            ) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MyMovieResponse>, t: Throwable) {
//                val intent= Intent(this,FailureActivity::class.java)
//                intent.putExtra("message",t.localizedMessage)
//                startActivity(intent)
//
            }

        })
    }
}
