package com.example.themovieapplication.di

import com.example.themovieapplication.service.MyMovieApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


// const val paymentsBaseUrl="https://6377200d5c4777651214a95a.mockapi.io/"

@InstallIn(SingletonComponent::class)
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
//        return Retrofit.Builder().baseUrl(paymentsBaseUrl)
//            .addConverterFactory(gsonConverterFactory).build()

    }


        @Singleton
        @Provides
    fun providesMovieApiInterface(retrofit: Retrofit): MyMovieApiInterface {
        return retrofit.create(MyMovieApiInterface::class.java)
    }
}