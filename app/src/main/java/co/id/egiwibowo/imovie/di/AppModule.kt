package co.id.egiwibowo.imovie.di

import co.id.egiwibowo.imovie.domain.usecases.MovieInteractor
import co.id.egiwibowo.imovie.domain.usecases.MovieUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

//    @Binds
//    abstract fun provideGetPopularMovieInteractor(getPopularMovieInteractor: GetPopularMoviesInteractor): GetPopularMoviesUseCase

    @Binds
    abstract fun provideTourismUseCase(tourismInteractor: MovieInteractor): MovieUseCase

}

//@Module
//class AppModule {
//
//    @AppScope
//    @Provides
//    fun provideMovieUSeCase(): GetPopularMoviesUseCase = GetPopularMoviesInteractor()
//
//}