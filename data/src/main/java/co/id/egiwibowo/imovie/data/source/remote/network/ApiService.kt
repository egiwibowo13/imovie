package co.id.egiwibowo.imovie.data.source.remote.network

import co.id.egiwibowo.imovie.data.source.remote.response.ListMovieResponse
import co.id.egiwibowo.imovie.data.source.remote.response.MovieDetailsResponse
import co.id.egiwibowo.imovie.domain.entities.Movie
import co.id.egiwibowo.imovie.domain.entities.MovieDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") api_key: String = "74078d381713cfc6b144cc4fc1e7aaef"): ListMovieResponse

    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") movieId: Int,
        @Query("api_key") api_key: String = "74078d381713cfc6b144cc4fc1e7aaef",
        @Query("append_to_response") append_to_response: String = "credits"
    ): MovieDetailsResponse

}