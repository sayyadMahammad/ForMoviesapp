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

class MainViewModel(private val myMovieApiInterface: MyMovieApiInterface):ViewModel() {
      private var _myMoviesList = MutableLiveData<List<MyMovies>>()
     val myMoviesList : LiveData<List<MyMovies>>
    get()= _myMoviesList

    private var failureFlag: MutableLiveData<Boolean> = MutableLiveData()
    private var loadingFlag: MutableLiveData<Boolean> = MutableLiveData()
    fun onFailureResponse():MutableLiveData<Boolean>{
        return failureFlag
    }
    fun onLoadingResponse():MutableLiveData<Boolean>{
     return loadingFlag
    }



      init {

            viewModelScope.launch {
                val apiResponse = myMovieApiInterface.getMoviesList()
                if (apiResponse.isSuccessful&&apiResponse.body()!=null) {
                    loadingFlag.postValue(true)
                    _myMoviesList.postValue(apiResponse.body()!!.movies)
                } else {
                    failureFlag.postValue(true)
                }
            }

      }







}
