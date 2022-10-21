package com.example.themovieapplication

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun providesRepo(repository:MoviesRepository):RepositoryInterface{
        return repository
    }
}