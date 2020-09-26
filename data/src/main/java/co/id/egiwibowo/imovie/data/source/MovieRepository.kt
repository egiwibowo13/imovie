package co.id.egiwibowo.imovie.data.source

import android.util.Log
import co.id.egiwibowo.imovie.abstraction.state.ApiResponse
import co.id.egiwibowo.imovie.abstraction.state.Resource
import co.id.egiwibowo.imovie.abstraction.utils.AppExecutors
import co.id.egiwibowo.imovie.abstraction.utils.NetworkBoundResource
import co.id.egiwibowo.imovie.data.source.local.LocalDataSource
import co.id.egiwibowo.imovie.data.source.remote.RemoteDataSource
import co.id.egiwibowo.imovie.data.source.remote.response.MovieResponse
import co.id.egiwibowo.imovie.data.utils.DataMapper
import co.id.egiwibowo.imovie.data.utils.MovieDetailsMapper
import co.id.egiwibowo.imovie.domain.entities.Movie
import co.id.egiwibowo.imovie.domain.entities.MovieDetails
import co.id.egiwibowo.imovie.domain.interfaces.IMovieRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IMovieRepository {


    override fun setFavoritMovie(movie: Movie, newState: Boolean) {
        val movieDB = DataMapper.mapDomainToDB(movie)
        localDataSource.setFavoriteMovie(movie = movieDB, newState = newState)
    }


    override fun getPopularMovies(): Flow<Resource<List<Movie>>> = object : NetworkBoundResource<List<Movie>, List<MovieResponse>>(appExecutors) {
        override fun loadFromDB(): Flow<List<Movie>> {
            return localDataSource.getPopularMovies().map { DataMapper.mapListDBToDomain(it) }
        }

        override fun shouldFetch(data: List<Movie>?): Boolean {
            return  data == null || data.isEmpty()
        }

        override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> {
            return remoteDataSource.getPopularMovies()
        }

        override suspend fun saveCallResult(data: List<MovieResponse>) {
            val movies = DataMapper.mapListResponsesToDB(data)
            localDataSource.insertMovies(movies)
        }

    }.asFlow()

    override fun getDetailMovie(movieId: Int): Flow<Resource<MovieDetails>> {
        return  flow {
            val apiResponse = remoteDataSource.getMovieDetails(movieId).first()
            when(apiResponse) {
                is ApiResponse.Error -> {
                    emit(Resource.Error(apiResponse.errorMessage))
                }
                is ApiResponse.Success -> {
                    emit(Resource.Success(MovieDetailsMapper.mapResponsesToDomain(apiResponse.data)))
                }
            }
        }
    }

    override fun getFavoritMovie(movieId: Int): Flow<Movie> {
        return flow {
            val listMovieDB = localDataSource.getFavoriteMovieById(movieId).first()
            Log.d("getFavoritMovie", listMovieDB.toString())
            if (listMovieDB.isNotEmpty()) {
                val movieDB = listMovieDB.get(0)
                DataMapper.mapDBToDomain(input = movieDB)
            }
        }
    }


}