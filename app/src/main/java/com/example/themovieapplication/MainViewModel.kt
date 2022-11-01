package com.example.themovieapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themovieapplication.models.MyMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (private val useCase :UseCase ):ViewModel() {
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

               val result= useCase.getMoviesUC()
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
