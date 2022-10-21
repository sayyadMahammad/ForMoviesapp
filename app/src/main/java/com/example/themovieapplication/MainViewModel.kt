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
    private var _myMoviesList = MutableLiveData<List<MyMovies>>()
     val myMoviesList : LiveData<List<MyMovies>>
    get()= _myMoviesList

    private var _failureFlag = MutableLiveData<Boolean>()
    private val failureFlag: LiveData<Boolean>
    get() =_failureFlag

    private var _loadingFlag = MutableLiveData<Boolean>()
    private val loadingFlag: LiveData<Boolean>
    get() = _loadingFlag

    fun onFailureResponse()=failureFlag
    fun onLoadingResponse()=loadingFlag




      init {

            viewModelScope.launch {

               val result= moviesRepository.getMovieList()
                if (result.isSuccessful&&result.body()!=null){
                    _loadingFlag.postValue(true)
                    _myMoviesList.postValue(result.body()!!.movies)


                }
                else {
                    _failureFlag.postValue(true)
                }
            }

      }







}
