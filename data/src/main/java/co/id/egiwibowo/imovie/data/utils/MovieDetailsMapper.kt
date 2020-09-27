package co.id.egiwibowo.imovie.data.utils

import co.id.egiwibowo.imovie.data.source.remote.response.MovieDetailsResponse
import co.id.egiwibowo.imovie.domain.entities.MovieDetails

object MovieDetailsMapper {
    fun mapResponsesToDomain(input: MovieDetailsResponse): MovieDetails {
        return MovieDetails(
            movieId = input.id,
            title = input.title,
            posterPath = input.posterPath,
            overview = input.overview,
            backdropPath = input.backdropPath,
            voteAverage = input.voteAverage,
            voteCount = input.voteCount,
            releaseDate = input.releaseDate,
            runtime = input.runtime.toString(),
            genres = mapGenre(input = input.genres),
            casts = mapCast(input = input.credits.cast)
        )
    }

    private fun mapGenre(input: List<MovieDetailsResponse.Genre>) : List<MovieDetails.Genre> {
        return input.map {
            MovieDetails.Genre(
                id = it.genreId,
                name = it.name
            )
        }
    }

    private fun mapCast(input: List<MovieDetailsResponse.Cast>) : List<MovieDetails.Cast> {
        return input.map {
            MovieDetails.Cast(
                castId = it.castId,
                name = it.name,
                character = it.character,
                profilePath = it.profilePath
            )
        }
    }
}