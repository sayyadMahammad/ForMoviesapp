package com.example.themovieapplication

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.themovieapplication.models.MyMovieResponse
import com.example.themovieapplication.models.MyMovies
import com.example.themovieapplication.service.MovieApiService
import com.example.themovieapplication.service.MyMovieApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel :ViewModel() {

    private var failureFlag: MutableLiveData<Boolean> = MutableLiveData()
    private var loadingFlag: MutableLiveData<Boolean> = MutableLiveData()
    fun onFailureResponse():MutableLiveData<Boolean>{
        return failureFlag
    }
    fun onLoadingResponse():MutableLiveData<Boolean>{
     return loadingFlag
    }


   suspend  fun getMovieData(callback: (List<MyMovies>)->Unit){

        val apiService = MovieApiService.getInstance().create(MyMovieApiInterface::class.java)
            val apiResponse=apiService.getMoviesList()
       if (apiResponse.isSuccessful){
           loadingFlag.postValue(true)
           return callback(apiResponse.body()!!.movies)
       }
       else{
           failureFlag.postValue(true)
       }






    }
}
