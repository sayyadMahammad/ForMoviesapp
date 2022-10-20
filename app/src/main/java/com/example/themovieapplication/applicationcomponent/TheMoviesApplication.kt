package com.example.themovieapplication.applicationcomponent

import android.app.Application
import com.example.themovieapplication.DaggerMoviesComponent
import com.example.themovieapplication.MoviesComponent

class TheMoviesApplication : Application() {
    lateinit var moviesComponent: MoviesComponent
    override fun onCreate() {
        super.onCreate()
        moviesComponent=DaggerMoviesComponent.builder().build()
    }

}