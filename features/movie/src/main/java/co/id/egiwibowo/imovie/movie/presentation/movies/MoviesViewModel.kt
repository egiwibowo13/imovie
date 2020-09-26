package co.id.egiwibowo.imovie.movie.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import co.id.egiwibowo.imovie.domain.usecases.MovieUseCase
import javax.inject.Inject

class MoviesViewModel @Inject constructor(private val movieUseCase: MovieUseCase) : ViewModel() {

    val movie = movieUseCase.getPopularMovies().asLiveData()

}