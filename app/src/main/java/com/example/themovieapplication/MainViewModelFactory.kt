package com.example.themovieapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.themovieapplication.service.MyMovieApiInterface
import javax.inject.Inject

class MainViewModelFactory @Inject constructor (private val mainViewModel: MainViewModel) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return mainViewModel as T
    }
}