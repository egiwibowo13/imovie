package co.id.egiwibowo.imovie.data.source.remote

import android.util.Log
import co.id.egiwibowo.imovie.abstraction.state.ApiResponse
import co.id.egiwibowo.imovie.data.source.remote.network.ApiService
import co.id.egiwibowo.imovie.data.source.remote.response.MovieDetailsResponse
import co.id.egiwibowo.imovie.data.source.remote.response.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getPopularMovies(): Flow<ApiResponse<List<MovieResponse>>> {
        return flow {
            try {
                val response = apiService.getPopularMovies()
                val dataArray = response.movies
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.movies))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getMovieDetails(movieId: Int): Flow<ApiResponse<MovieDetailsResponse>> {
        return flow {
            try {
                val response = apiService.getMovieDetails(movieId = movieId)
                if (response != null) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}