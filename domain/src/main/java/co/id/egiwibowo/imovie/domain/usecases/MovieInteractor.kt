package co.id.egiwibowo.imovie.domain.usecases

import co.id.egiwibowo.imovie.abstraction.state.Resource
import co.id.egiwibowo.imovie.domain.entities.Movie
import co.id.egiwibowo.imovie.domain.entities.MovieDetails
import co.id.egiwibowo.imovie.domain.interfaces.IMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieInteractor @Inject constructor(private val movieRepository: IMovieRepository): MovieUseCase {

    override fun getPopularMovies(): Flow<Resource<List<Movie>>> = movieRepository.getPopularMovies()

    override fun setFavoritMovie(movie: Movie, newState: Boolean) {
        movieRepository.setFavoritMovie(movie, newState)
    }

    override fun getFavoritMovieById(movieId: Int): Flow<Movie> {
        return movieRepository.getFavoritMovie(movieId)
    }

    override fun getMovieDetails(movieId: Int): Flow<Resource<MovieDetails>> {
        return movieRepository.getDetailMovie(movieId)
    }


}