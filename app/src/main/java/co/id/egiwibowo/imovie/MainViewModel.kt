package co.id.egiwibowo.imovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import co.id.egiwibowo.imovie.domain.entities.Movie
import co.id.egiwibowo.imovie.domain.usecases.MovieUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(private val movieUseCase: MovieUseCase) : ViewModel() {

    private val _result = MutableLiveData<MutableList<Movie>>()
    val result: LiveData<MutableList<Movie>>
        get() = _result

    val popularMovies = movieUseCase.getPopularMovies().asLiveData()

}