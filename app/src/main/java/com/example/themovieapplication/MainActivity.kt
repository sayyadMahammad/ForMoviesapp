package com.example.themovieapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themovieapplication.models.MyMovieResponse
import com.example.themovieapplication.models.MyMovies
import com.example.themovieapplication.service.MovieApiService
import com.example.themovieapplication.service.MyMovieApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    //companion object  { val INTENT_PARCELABLE = "OBJECT_INTENT"     }  //
   lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        moviestList.layoutManager=LinearLayoutManager(this)
        moviestList.setHasFixedSize(true)

        GlobalScope.launch(Dispatchers.IO) {
            mainViewModel.getMovieData { movies: List<MyMovies> ->
                moviestList.adapter = MyMoviesAdapter(this@MainActivity, movies) {
                    val intent = Intent(this@MainActivity, DetailsActivity::class.java)//
                    //intent.putExtra(INTENT_PARCELABLE,it)
                    startActivity(intent)

                }
            }
        }
    }


}