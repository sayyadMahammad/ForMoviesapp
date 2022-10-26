package com.example.themovieapplication.applicationcomponent

import android.app.Application
import com.example.themovieapplication.di.DaggerMoviesComponent

import com.example.themovieapplication.di.MoviesComponent



class TheMoviesApplication : Application() {
    lateinit var moviesComponent : MoviesComponent
    override fun onCreate() {
        super.onCreate()

        moviesComponent = DaggerMoviesComponent.builder().build()
    }

}