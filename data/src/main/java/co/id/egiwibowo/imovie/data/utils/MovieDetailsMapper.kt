package co.id.egiwibowo.imovie.data.utils

import co.id.egiwibowo.imovie.data.source.remote.response.MovieDetailsResponse
import co.id.egiwibowo.imovie.domain.entities.MovieDetails
import java.text.DecimalFormat

object MovieDetailsMapper {
    fun mapResponsesToDomain(input: MovieDetailsResponse): MovieDetails {
        return MovieDetails(
            movieId = input.id,
            title = input.title,
            posterPath = input.posterPath,
            overview = input.overview,
            backdropPath = input.backdropPath,
            rating = input.voteAverage.toString(),
            voteCount = input.voteCount,
            releaseDate = input.releaseDate,
            runtime = mapRuntimeToHours(input.runtime),
            genres = mapGenre(input = input.genres),
            casts = mapCast(input = input.credits.cast),
            originalTitle = input.originalTitle,
            status = input.status,
            budget = mapIntToPrice(input.budget),
            revenue = mapIntToPrice(input.revenue),
            recommend = mapRecommendMovie(input = input.recommendations.results)
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

    private fun mapIntToPrice(input: Int): String {
        val dec = DecimalFormat("#,###.##")
        return  "$ " + dec.format(input)
    }

    private fun mapRuntimeToHours(input: Int): String {
        val hours: Int = input / 60
        val minutes: Int = input % 60
        return "${hours}h ${minutes}min"
    }

    private fun mapRecommendMovie(input: List<MovieDetailsResponse.RecommendationMovie> ): List<MovieDetails.RecommendMovie> {
        return input.map {
            MovieDetails.RecommendMovie(
                movieId = it.movieId,
                title = it.title,
                rating = it.voteAverage.toString(),
                posterPath = it.posterPath
            )
        }
    }
}