package co.id.egiwibowo.imovie.data.di

import co.id.egiwibowo.imovie.abstraction.utils.AppExecutors
import co.id.egiwibowo.imovie.data.source.MovieRepository
import co.id.egiwibowo.imovie.data.source.local.LocalDataSource
import co.id.egiwibowo.imovie.data.source.remote.RemoteDataSource
import co.id.egiwibowo.imovie.domain.interfaces.IMovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(movieRepository: MovieRepository): IMovieRepository

}

//@Module
//class RepositoryModule {
//
//    @Singleton
//    @Provides
//    fun provideRepository(): IMovieRepository = MovieRepository()
//
//}