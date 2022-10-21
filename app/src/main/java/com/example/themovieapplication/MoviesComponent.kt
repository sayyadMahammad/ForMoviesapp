package com.example.themovieapplication

import com.example.themovieapplication.service.NetworkModule
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules=[NetworkModule::class,RepositoryModule::class])
interface MoviesComponent {
    fun inject(mainActivity: MainActivity)
}