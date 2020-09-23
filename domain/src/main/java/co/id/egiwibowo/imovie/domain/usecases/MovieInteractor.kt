package co.id.egiwibowo.imovie.domain.usecases

import co.id.egiwibowo.imovie.abstraction.state.Resource
import co.id.egiwibowo.imovie.domain.entities.Movie
import co.id.egiwibowo.imovie.domain.interfaces.IMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieInteractor @Inject constructor(private val movieRepository: IMovieRepository): MovieUseCase {

    override fun getPopularMovies(): Flow<Resource<List<Movie>>> = movieRepository.getPopularMovies()

    override fun setFavorit() {
        movieRepository.setFavoritMovie(
            Movie(
                movieId = 1,
                title = "title",
                posterPath = "posterpath",
                overview = "overview",
                backdropPath = "",
                voteAverage = 1.toFloat(),
                voteCount = 1,
                releaseDate = "re",
                isFavorite = true
            )
        )
    }


}