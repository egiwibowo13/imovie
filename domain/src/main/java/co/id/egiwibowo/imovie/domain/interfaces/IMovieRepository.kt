package co.id.egiwibowo.imovie.domain.interfaces

import co.id.egiwibowo.imovie.abstraction.state.Resource
import co.id.egiwibowo.imovie.domain.entities.Movie
import co.id.egiwibowo.imovie.domain.entities.MovieDetails
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun setFavoritMovie(movie: Movie, newState: Boolean)
    fun getPopularMovies(): Flow<Resource<List<Movie>>>
    fun getDetailMovie(movieId: Int): Flow<Resource<MovieDetails>>
    fun getFavoritMovie(movieId: Int): Flow<Movie>
}