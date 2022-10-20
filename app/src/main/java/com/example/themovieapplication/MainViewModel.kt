package com.example.themovieapplication

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themovieapplication.models.MyMovieResponse
import com.example.themovieapplication.models.MyMovies
import com.example.themovieapplication.service.MovieApiService
import com.example.themovieapplication.service.MyMovieApiInterface
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainViewModel @Inject constructor (private val moviesRepository: MoviesRepository):ViewModel() {

     val myMoviesList : LiveData<List<MyMovies>>
    get()= moviesRepository.moviesList

    private val failureFlag: LiveData<Boolean>
    get() = moviesRepository.failureFlag

    private val loadingFlag: LiveData<Boolean>
    get() = moviesRepository.loadindFlag


    fun onFailureResponse(): LiveData<Boolean>{
        return failureFlag
    }
    fun onLoadingResponse():LiveData<Boolean>{
     return loadingFlag
    }



      init {

            viewModelScope.launch {

                moviesRepository.getMovieList()
            }

      }







}
