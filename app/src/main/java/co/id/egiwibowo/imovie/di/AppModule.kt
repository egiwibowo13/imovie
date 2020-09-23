package co.id.egiwibowo.imovie.di

import co.id.egiwibowo.imovie.domain.usecases.MovieInteractor
import co.id.egiwibowo.imovie.domain.usecases.MovieUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideMovieUseCase(movieInteractor: MovieInteractor): MovieUseCase

}