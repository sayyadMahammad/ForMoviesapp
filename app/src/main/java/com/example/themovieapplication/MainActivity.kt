package com.example.themovieapplication

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
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
   lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        moviestList.layoutManager=LinearLayoutManager(this)
        moviestList.setHasFixedSize(true)

        val dialog = Dialog(this)
        dialog.apply {
            setContentView(R.layout.progressbar_item)
            setCancelable(true)
             show()
        }

        mainViewModel.apply {
            onLoadingResponse().observe(this@MainActivity,{
                if(it) { dialog.dismiss()}
            })
           onFailureResponse().observe(this@MainActivity,{
                if(it) {
                    var intent = Intent(this@MainActivity, FailureActivity::class.java)
                    startActivity(intent)
                }

            })
        }



        GlobalScope.launch(Dispatchers.Main) {
            mainViewModel.getMovieData { movies: List<MyMovies> ->
                moviestList.adapter = MyMoviesAdapter(this@MainActivity, movies) {
                    val intent = Intent(this@MainActivity, DetailsActivity::class.java)//
                    startActivity(intent)

                }
            }
        }
    }


}