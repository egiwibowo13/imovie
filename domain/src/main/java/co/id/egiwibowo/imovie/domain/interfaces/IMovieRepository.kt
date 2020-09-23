package co.id.egiwibowo.imovie.domain.interfaces

import co.id.egiwibowo.imovie.abstraction.state.Resource
import co.id.egiwibowo.imovie.domain.entities.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun setFavoritMovie(movie: Movie)
    fun getPopularMovies(): Flow<Resource<List<Movie>>>
}