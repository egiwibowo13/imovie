package co.id.egiwibowo.imovie.movie.presentation.movie_details

import android.util.Log
import androidx.lifecycle.*
import co.id.egiwibowo.imovie.abstraction.state.Resource
import co.id.egiwibowo.imovie.domain.entities.MovieDetails
import co.id.egiwibowo.imovie.domain.usecases.MovieUseCase
import javax.inject.Inject

class MovieDetailsViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase
) : ViewModel() {

    var movieDetails: LiveData<Resource<MovieDetails>> = MutableLiveData<Resource<MovieDetails>>()

    val movie = movieUseCase.getFavoritMovieById(movieId = 337401).asLiveData()

    private var _isFavorit = MutableLiveData<Boolean>()
    val isFavorit: LiveData<Boolean> = _isFavorit


    fun setFavorit() {
        if (isFavorit.value != null && movie.value != null) {
            _isFavorit.value = !isFavorit.value!!
            movieUseCase.setFavoritMovie(movie = movie.value!!, newState = isFavorit.value!!)
        }
    }

    fun getMovieDetails(movieId: Int) {
        movieDetails = movieUseCase.getMovieDetails(movieId = movieId).asLiveData()
    }


}