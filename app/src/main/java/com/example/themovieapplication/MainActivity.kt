package com.example.themovieapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themovieapplication.models.MyMovieResponse
import com.example.themovieapplication.models.MyMovies
import com.example.themovieapplication.service.MovieApiService
import com.example.themovieapplication.service.MyMovieApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moviestList.layoutManager=LinearLayoutManager(this)
        moviestList.setHasFixedSize(true)
        getMovieData { movies : List<MyMovies>->
            moviestList.adapter=MyMoviesAdapter(movies)
        }
    }

    private fun getMovieData(callback: (List<MyMovies>)->Unit){
        val apiService = MovieApiService.getInstance().create(MyMovieApiInterface::class.java)
        apiService.getMoviesList().enqueue(object : Callback<MyMovieResponse>{
            override fun onResponse(
                call: Call<MyMovieResponse>,
                response: Response<MyMovieResponse>
            ) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MyMovieResponse>, t: Throwable) {
                Toast.makeText(applicationContext,t.localizedMessage,Toast.LENGTH_LONG).show()
            }

        })
    }
}