package co.id.egiwibowo.imovie.data.source.local

import co.id.egiwibowo.imovie.data.source.local.model.DBMovie
import co.id.egiwibowo.imovie.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val movieDao: MovieDao) {


    fun getPopularMovies(): Flow<List<DBMovie>> = movieDao.getPopularMovies()

    fun getFavoriteMovies(): Flow<List<DBMovie>> = movieDao.getFavoritMovies()

    suspend fun insertMovies(movies: List<DBMovie>) = movieDao.insertMovie(movies)

    fun setFavoriteMovie(movie: DBMovie, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updateFavoriteMovie(movie)
    }
}