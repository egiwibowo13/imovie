package co.id.egiwibowo.imovie.movie.di

import co.id.egiwibowo.imovie.domain.usecases.MovieInteractor
import co.id.egiwibowo.imovie.domain.usecases.MovieUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class MovieModule {

    @Binds
    abstract fun provideMovieUseCase(movieInteractor: MovieInteractor): MovieUseCase

}