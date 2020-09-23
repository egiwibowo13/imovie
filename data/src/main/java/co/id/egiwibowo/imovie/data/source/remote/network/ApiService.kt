package co.id.egiwibowo.imovie.data.source.remote.network

import co.id.egiwibowo.imovie.data.source.remote.response.ListMovieResponse
import co.id.egiwibowo.imovie.domain.entities.Movie
import retrofit2.http.GET

interface ApiService {

    @GET("/movie/popular")
    suspend fun getPopularMovies(): ListMovieResponse

}