package co.id.egiwibowo.imovie.data.source

import co.id.egiwibowo.imovie.abstraction.state.ApiResponse
import co.id.egiwibowo.imovie.abstraction.state.Resource
import co.id.egiwibowo.imovie.abstraction.utils.AppExecutors
import co.id.egiwibowo.imovie.abstraction.utils.NetworkBoundResource
import co.id.egiwibowo.imovie.data.source.local.LocalDataSource
import co.id.egiwibowo.imovie.data.source.remote.RemoteDataSource
import co.id.egiwibowo.imovie.data.source.remote.response.MovieResponse
import co.id.egiwibowo.imovie.data.utils.DataMapper
import co.id.egiwibowo.imovie.domain.entities.Movie
import co.id.egiwibowo.imovie.domain.interfaces.IMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IMovieRepository {


    override fun setFavoritMovie(movie: Movie) {
        val movieDB = DataMapper.mapDomainToDB(movie)
        localDataSource.setFavoriteMovie(movie = movieDB, newState = true)
    }


    override fun getPopularMovies(): Flow<Resource<List<Movie>>> = object : NetworkBoundResource<List<Movie>, List<MovieResponse>>(appExecutors) {
        override fun loadFromDB(): Flow<List<Movie>> {
            return localDataSource.getPopularMovies().map { DataMapper.mapDBToDomain(it) }
        }

        override fun shouldFetch(data: List<Movie>?): Boolean {
            return  data == null || data.isEmpty()
        }

        override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> {
            return remoteDataSource.getPopularMovies()
        }

        override suspend fun saveCallResult(data: List<MovieResponse>) {
            val movies = DataMapper.mapResponsesToDB(data)
            localDataSource.insertMovies(movies)
        }

    }.asFlow()

}