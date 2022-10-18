package com.example.themovieapplication.service

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

        @Singleton
        @Provides
    fun providesMovieApiInterface():MyMovieApiInterface{
        return Retrofit.Builder().baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(MyMovieApiInterface::class.java)
    }
}