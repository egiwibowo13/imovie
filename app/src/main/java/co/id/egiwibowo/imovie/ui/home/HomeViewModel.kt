package co.id.egiwibowo.imovie.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import co.id.egiwibowo.imovie.domain.usecases.MovieUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val movieUseCase: MovieUseCase) : ViewModel() {

    val popularMovies = movieUseCase.getPopularMovies().asLiveData()

}