package co.id.egiwibowo.imovie.domain.usecases

import co.id.egiwibowo.imovie.abstraction.state.Resource
import co.id.egiwibowo.imovie.domain.entities.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getPopularMovies(): Flow<Resource<List<Movie>>>
    fun setFavorit()
}