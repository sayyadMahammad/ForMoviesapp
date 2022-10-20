package com.example.themovieapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.themovieapplication.models.MyMovies
import com.example.themovieapplication.service.MyMovieApiInterface
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val myMovieApiInterface: MyMovieApiInterface) {
    private var _moviesList = MutableLiveData<List<MyMovies>>()
    val moviesList : LiveData<List<MyMovies>>
    get() = _moviesList



    private var _failureFlag: MutableLiveData<Boolean> = MutableLiveData()
    private var _loadingFlag: MutableLiveData<Boolean> = MutableLiveData()

    val failureFlag : LiveData<Boolean>
        get() =_failureFlag

    val loadindFlag : LiveData<Boolean>
      get() = _loadingFlag


    suspend fun getMovieList(){
       val apiResponse = myMovieApiInterface.getMoviesList()
       if(apiResponse.isSuccessful&&apiResponse.body()!=null){
           _loadingFlag.postValue(true)
           _moviesList.postValue(apiResponse.body()!!.movies)
       }
       else {
           _failureFlag.postValue(true)

       }

    }


}