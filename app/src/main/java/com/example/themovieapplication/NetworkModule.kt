package com.example.themovieapplication

import com.example.themovieapplication.service.MyMovieApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesGson():GsonConverterFactory{
            return GsonConverterFactory.create()
    }


    @Singleton
    @Provides
    fun proviedsRetrofit(gsonConverterFactory: GsonConverterFactory):Retrofit{
        return Retrofit.Builder().baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(gsonConverterFactory).build()
    }


        @Singleton
        @Provides
    fun providesMovieApiInterface(retrofit: Retrofit): MyMovieApiInterface {
        return retrofit.create(MyMovieApiInterface::class.java)
    }
}