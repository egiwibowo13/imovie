package co.id.egiwibowo.imovie.movie.presentation.movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import co.id.egiwibowo.imovie.domain.usecases.MovieUseCase
import javax.inject.Inject

class MovieDetailsViewModel @Inject constructor(private val movieUseCase: MovieUseCase) : ViewModel() {

    val movieDetails = movieUseCase.getMovieDetails(movieId = 337401).asLiveData()

    val movie = movieUseCase.getFavoritMovieById(movieId = 337401).asLiveData()

    private var _isFavorit = MutableLiveData<Boolean>().apply { postValue(movie.value?.isFavorite)}
    val isFavorit: LiveData<Boolean> = _isFavorit


    fun setFavorit() {
        if (isFavorit.value != null && movie.value != null) {
            _isFavorit.value = !isFavorit.value!!
            movieUseCase.setFavoritMovie(movie = movie.value!!, newState = isFavorit.value!!)
        }
    }


}