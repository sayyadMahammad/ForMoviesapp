package com.example.themovieapplication.di

import com.example.themovieapplication.MoviesRepository
import com.example.themovieapplication.MoviesRepositoryImplementation
import com.example.themovieapplication.UseCase
import com.example.themovieapplication.UseCaseImp
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Singleton
    @Binds
  abstract  fun providesRepo(moviesRepositoryImplementation: MoviesRepositoryImplementation): MoviesRepository

  @Singleton
  @Binds
  abstract fun providesUseCase(useCaseImplementation: UseCaseImp): UseCase
}