package co.id.egiwibowo.imovie.data.di

import android.content.Context
import androidx.room.Room
import co.id.egiwibowo.imovie.data.source.local.room.MovieDao
import co.id.egiwibowo.imovie.data.source.local.room.MovieDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): MovieDatabase = Room.databaseBuilder(
        context,
        MovieDatabase::class.java, "Movie.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideMovieDao(database: MovieDatabase): MovieDao = database.movieDao()
}