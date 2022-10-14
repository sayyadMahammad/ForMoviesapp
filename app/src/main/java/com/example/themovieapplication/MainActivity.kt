package com.example.themovieapplication

import android.content.Intent
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
    //companion object  { val INTENT_PARCELABLE = "OBJECT_INTENT"     }  //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moviestList.layoutManager=LinearLayoutManager(this)
        moviestList.setHasFixedSize(true)
        getMovieData { movies : List<MyMovies>->
            moviestList.adapter=MyMoviesAdapter(this,movies){
                val intent = Intent(this,DetailsActivity::class.java)//
              //intent.putExtra(INTENT_PARCELABLE,it)
                startActivity(intent)

            }
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
//                Toast.makeText(applicationContext,t.localizedMessage,Toast.LENGTH_LONG).show()
                val intent=Intent(this@MainActivity,FailureActivity::class.java)
                intent.putExtra("message",t.localizedMessage)
                startActivity(intent)
            }

        })
    }
}