package com.example.themovieapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.themovieapplication.service.MyMovieApiInterface
import javax.inject.Inject

class MainViewModelFactory @Inject constructor (private val myMovieApiInterface: MyMovieApiInterface) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(myMovieApiInterface) as T
    }
}