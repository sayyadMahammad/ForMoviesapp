package com.example.themovieapplication.applicationcomponent

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class TheMoviesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

}