package co.id.egiwibowo.imovie.domain.usecases

import co.id.egiwibowo.imovie.abstraction.state.Resource
import co.id.egiwibowo.imovie.domain.entities.Movie
import co.id.egiwibowo.imovie.domain.entities.MovieDetails
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getPopularMovies(): Flow<Resource<List<Movie>>>
    fun setFavoritMovie(movie: Movie, newState: Boolean)
    fun getFavoritMovieById(movieId: Int): Flow<Movie>
    fun getMovieDetails(movieId: Int): Flow<Resource<MovieDetails>>
}