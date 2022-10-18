package com.example.themovieapplication

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
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
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var moviesComponent: MoviesComponent

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moviesComponent = DaggerMoviesComponent.builder().build()
        moviesComponent.inject(this)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)
        moviestList.layoutManager = LinearLayoutManager(this)
         moviestList.setHasFixedSize(true)

        val dialog = Dialog(this)
        dialog.apply {
            setContentView(R.layout.progressbar_item)
            setCancelable(true)
            show()
        }




        mainViewModel.apply {

            myMoviesList.observe(this@MainActivity, Observer {
                moviestList.adapter = MyMoviesAdapter(this@MainActivity, it) {
                   val intent = Intent(this@MainActivity, DetailsActivity::class.java)//
                    startActivity(intent)

               }
            })
            onLoadingResponse().observe(this@MainActivity, Observer{
                if (it) {
                    dialog.dismiss()
                }
            })
            onFailureResponse().observe(this@MainActivity, Observer{
                if (it) {
                    var intent = Intent(this@MainActivity, FailureActivity::class.java)
                    startActivity(intent)
                }

            })
        }





    }
}