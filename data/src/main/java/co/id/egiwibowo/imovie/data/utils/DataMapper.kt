package co.id.egiwibowo.imovie.data.utils

import co.id.egiwibowo.imovie.data.source.local.model.DBMovie
import co.id.egiwibowo.imovie.data.source.remote.response.MovieResponse
import co.id.egiwibowo.imovie.domain.entities.Movie

object DataMapper {
    fun mapListResponsesToDB(input: List<MovieResponse>): List<DBMovie> {
        val movies = ArrayList<DBMovie>()
        input.map {
            val movie = DBMovie(
                movieId = it.id,
                title = it.title,
                overview = it.overview,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                voteCount = it.voteCount,
                voteAverage = it.voteAverage.toString(),
                releaseDate = it.releaseDate,
                isFavorite = false
            )
            movies.add(movie)
        }
        return movies
    }

    fun mapListDBToDomain(input: List<DBMovie>): List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                title = it.title,
                overview = it.overview,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                voteCount = it.voteCount,
                rating = it.voteAverage,
                releaseDate = it.releaseDate,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToDB(input: Movie) = DBMovie(
        movieId = input.movieId,
        title = input.title,
        overview = input.overview,
        posterPath = input.posterPath,
        backdropPath = input.backdropPath,
        voteCount = input.voteCount,
        voteAverage = input.rating,
        releaseDate = input.releaseDate,
        isFavorite = input.isFavorite
    )

    fun mapDBToDomain(input: DBMovie) = Movie(
        movieId = input.movieId,
        title = input.title,
        overview = input.overview,
        posterPath = input.posterPath,
        backdropPath = input.backdropPath,
        voteCount = input.voteCount,
        rating = input.voteAverage,
        releaseDate = input.releaseDate,
        isFavorite = input.isFavorite
    )
}