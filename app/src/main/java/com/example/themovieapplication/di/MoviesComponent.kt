package com.example.themovieapplication.di

import androidx.lifecycle.ViewModel
import com.example.themovieapplication.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules=[NetworkModule::class, RepositoryModule::class,ViewModelModule::class])
interface MoviesComponent {
    fun inject(mainActivity: MainActivity)
    fun getMap():Map<Class<*>, ViewModel>

}